import scala.math._
import org.apache.sysml.api.mlcontext._
import org.apache.sysml.api.mlcontext.ScriptFactory._
import org.apache.sysml.api.mlcontext.MatrixFormat._
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf
import org.apache.spark.sql._
import scala.io.Source
import scala.tools.nsc.io._
import scala.collection.immutable._
import org.apache.spark.storage.StorageLevel._
import org.apache.spark.ml.{linalg => alg}
import org.apache.spark.mllib.{linalg => malg}
import org.apache.spark.mllib.linalg.distributed._
import java.io.ByteArrayInputStream
import java.io.FileInputStream
import java.io.{File=>FileJava}
import java.io.SequenceInputStream
import java.nio.file.{StandardCopyOption, Paths, Files, Path}
import org.apache.spark.sql.DataFrame

val scriptArgs = sc.getConf.get("spark.driver.args").split(",")
val tweets =  scriptArgs(0)
val User =  scriptArgs(1)
val Tweet =  scriptArgs(2)
val TweetIDs =  scriptArgs(3)
val HashtageIDs =  scriptArgs(4)
val C = scriptArgs(5)
val X = scriptArgs(6)

def getFileName(dir: String):String = {
    val d = new FileJava(dir)
    if (d.exists && d.isDirectory) {
        d.listFiles.filter(f=>f.isFile && f.getName.contains("part-") && f.getName.contains(".csv")).toList(0).getName
    } else {
       ""
    }
}

def constructSparseMatirx(rows:Long,cols:Long,result:DataFrame,fileName:String): Unit = {

    val stringToPrepend = new ByteArrayInputStream(("%%MatrixMarket matrix coordinate integer general\n"+rows+" "+cols+" "+(rows*cols)+"\n").getBytes)
    spark.time( result.coalesce(1).write.format("csv").mode("overwrite").option("delimiter"," ").save(fileName+".temp"))
    val tempFile = new FileInputStream(fileName+".temp/"+getFileName(fileName+".temp"))
    Files.copy(
        new SequenceInputStream(stringToPrepend, tempFile),
        Paths.get(fileName),
        StandardCopyOption.REPLACE_EXISTING
    )
}

def constructMatirx(result:DataFrame,fileName:String): Unit = {
   val stringToPrepend = new ByteArrayInputStream(("").getBytes)
   spark.time( result.coalesce(1).write.format("csv").mode("overwrite").option("delimiter",",").save(fileName+".temp"))
   val tempFile = new FileInputStream(fileName+".temp/"+getFileName(fileName+".temp"))
   Files.copy(
        new SequenceInputStream(stringToPrepend,tempFile),
        Paths.get(fileName),
        StandardCopyOption.REPLACE_EXISTING
    )
}

val sqlContext = new org.apache.spark.sql.SQLContext(sc)


val df = spark.read.json(s"${tweets}")
df.createOrReplaceTempView("TweetJSON")
val SJDF = spark.sql("""SELECT id
                        FROM TweetJSON
                        WHERE text LIKE '%Election%'""")

SJDF.createOrReplaceTempView("SJDF")
spark.time(SJDF.count())

//Preprocessing M
val user = sqlContext.read.format("csv").option("header", "true").load(s"${User}");
user.createOrReplaceTempView("User")

val tweet = sqlContext.read.format("csv").option("header", "true").load(s"${Tweet}");
tweet.createOrReplaceTempView("TWeet")

val M = spark.sql("""SELECT * 
                     FROM User as U, TWeet as T 
                     WHERE  T.id = U.id""")
val M2 = M.drop("id")
println(M2.count())
constructMatirx (M2,"M.csv");


//Preprocessing  (N)
val tweetIDs = sqlContext.read.format("csv").option("header", "true").load(s"${TweetIDs}");
tweetIDs.createOrReplaceTempView("TweetIDs")

val hashtageIDs = sqlContext.read.format("csv").option("header", "true").load(s"${HashtageIDs}");
hashtageIDs.createOrReplaceTempView("HashtageIDs")

//Explode Hashtags
val Hashtags = spark.sql("""SELECT explode(entities.hashtags.text) as hashtag , id
                            FROM TweetJSON 
                            where entities.hashtags is not null""")

Hashtags.createOrReplaceTempView("Hashtags")

spark.time(Hashtags.count())
val  results = spark.sql("""SELECT t2.idIn, hID.id, t1.filter_level  
                            FROM TweetJSON as t1, TweetIDs as t2, HashtageIDs as hID,
                                 Hashtags as h, SJDF as SD
                            WHERE t1.id=t2.id  AND
                                  t1.id = h.id AND
                                  SD.id = t2.idIn AND
                                  hID.hashtag = h.hashtag AND
                                  t1.place.country_code ='US' AND 
                                  t2.idIn <=538000 AND
                                  hID.id <=1000
                        """)
val results2 = results.dropDuplicates();
constructSparseMatirx (538000,1000,results2,"N.mtx");

//Analysis
try{
val ml = new MLContext(spark)
val outputPath = "Exp0.5M/Q1-10/results-Q.out"
ml.setConfigProperty("sysml.cp.parallel.ops","true")
ml.setConfigProperty("sysml.optlevel","2")
ml.setConfigProperty("sysml.localtmpdir","systemml")

val dmlTextQuery =
  s"""
    | time = externalFunction(Integer i) return (Double B)
    |       implemented in (classname="org.apache.sysml.udf.lib.TimeWrapper", exectype="mem");
    |  timesQ = matrix(0.0, rows = 3, cols = 1)
    |  M  = read("M.csv", format="csv", header=FALSE, sep=",")
    |  N  = readMM("N.mtx")
    |  X = read("${X}", format="csv", header=FALSE, sep=",");
    |  C = read("${C}", format="csv", header=FALSE, sep=",");
    | for (ix in 1:3) {
    |   start = time(1)
    |   print("StartTime: "+start)
    |   NF = ifelse(N<=2,N,0)
    |   while(FALSE){}
    |   print(as.scalar(NF[3155,400]))
    |   res = NF*sum((X+C)%*%M)
    |   while(FALSE){}
    |   print(res)
    |   end = time(1)
    |   print("StartTime: "+end)
    |   pipTime = (end - start)/1000
    |   print ("TimeQ:"+ pipTime)
    |   timesQ[ix,1] = pipTime
    | }
    | timesQ = t(timesQ)
""".stripMargin
if (!Files.exists(Paths.get(outputPath))) {
File(outputPath).writeAll("-results-\n")
}
val scriptQ = dml(dmlTextQuery).out("timesQ")
val resQ = ml.execute(scriptQ)
val resultsQ = resQ.getTuple[Matrix]("timesQ")._1.to2DDoubleArray
File(outputPath).appendAll("MIMICHybridQ:");
File(outputPath).appendAll(resultsQ(0).mkString(",") + '\n')
}
catch{
     case e: Exception =>{ 
        e.printStackTrace
        System.exit(0)
    }
}
System.exit(0)
