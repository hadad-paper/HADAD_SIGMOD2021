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
import java.nio.file.{StandardCopyOption, Paths, F:q!iles, Path}
import org.apache.spark.sql.DataFrame

val scriptArgs = sc.getConf.get("spark.driver.args").split(",")
val tweets =  scriptArgs(0)
val TweetIDs =  scriptArgs(1)
val HashtageIDs =  scriptArgs(2)
val C = scriptArgs(3)
val V = scriptArgs(4)
val X = scriptArgs(5)

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

//-----------------------TEXT------------------------//
//----------Solr 
val options = Map("zkhost"->"localhost:9983",
                  "collection"->"tweetText",
                  "query"->"covid",
                  "fields"->"id",
                  "request_handler"->"/select")

val SJDF = spark.read.format("solr").options(options).load
SJDF.createOrReplaceTempView("SJDF")

println("*******Solr*****");
spark.time(SJDF.count())


//----------Spark
val df = spark.read.json(s"${tweets}")
df.createOrReplaceTempView("TweetJSON")


//Preprocessing  (N)
val TweetIDs = sqlContext.read.format("csv").option("header", "true").load(s"${TweetIDs}");
TweetIDs.createOrReplaceTempView("TweetIDs")

val HashtageIDs = sqlContext.read.format("csv").option("header", "true").load(s"${HashtageIDs}");
HashtageIDs.createOrReplaceTempView("HashtageIDs")


val VV2 = sqlContext.read.format("csv").option("header", "true").load(s"${VV2}");
VV2.createOrReplaceTempView("VV2")


val  results = spark.sql("""SELECT t2.idIn, hID.id, v.filter_level  
                            FROM  VV2 as v, TweetIDs as t2, HashtageIDs as hID, SJDF as SD
                            WHERE v.id=t2.id  AND
                                  SD.id = t2.idIn AND
                                  hID.hashtag =v.hashtag AND
                                  v.country_code ='US' AND 
                                  t2.idIn <=2380000 AND
                                  hID.id <=1000 AND
                                  v.filter_level<=2
                        """)
println("*******All*****");
val results2 = results.dropDuplicates();
constructSparseMatirx (2380000,1000,results2,"N.mtx");
//Analysis
try{
val ml = new MLContext(spark)
val outputPath = "Exp2M/Q1-8/results-RW.out"
ml.setConfigProperty("sysml.cp.parallel.ops","true")
ml.setConfigProperty("sysml.optlevel","2")
ml.setConfigProperty("sysml.localtmpdir","systemml")

//DML Query
val dmlTextQuery =
  s"""
    | time = externalFunction(Integer i) return (Double B)
    |       implemented in (classname="org.apache.sysml.udf.lib.TimeWrapper", exectype="mem");
    |  timesQ = matrix(0.0, rows = 3, cols = 1)
    |  VV1 = read("Exp2M/Q1-8/VV1.csv", format="csv", header=FALSE, sep=","); 
    |  N  = readMM("N.mtx");
    |  C = read("${C}", format="csv", header=FALSE, sep=",");
    |  V= read("${V}", format="csv", header=FALSE, sep=",");
    |  X = read("${X}", format="csv", header=FALSE, sep=",");
    | for (ix in 1:3) {
    |   start = time(1)
    |   print("StartTime: "+start)
    |   res = N*(trace(C)+trace(V%*%VV1%*%X%*%C))
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

}catch{
     case e: Exception =>{ 
        e.printStackTrace
        System.exit(0)
    }
}
System.exit(0)
