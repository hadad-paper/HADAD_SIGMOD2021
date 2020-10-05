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


val V1Amazon = scriptArgs(0)
val Syn9 = scriptArgs(1)
val Syn8 = scriptArgs(2)

def getFileName(dir: String):String = {
    val d = new FileJava(dir)
    if (d.exists && d.isDirectory) {
        d.listFiles.filter(f=>f.isFile && f.getName.contains("part-") && f.getName.contains(".csv")).toList(0).getName
    } else {
       ""
    }
}
def constructMatirx(rows:Long,cols:Long,result:DataFrame,fileName:String): Unit = {

    val stringToPrepend = new ByteArrayInputStream(("%%MatrixMarket matrix coordinate integer general\n"+rows+" "+cols+" "+(rows*cols)+"\n").getBytes)
   spark.time(result.coalesce(1).write.format("csv").mode("overwrite").option("delimiter"," ").save(fileName+".temp"))
    val tempFile = new FileInputStream(fileName+".temp/"+getFileName(fileName+".temp"))
    Files.copy(
        new SequenceInputStream(stringToPrepend, tempFile),
        Paths.get(fileName),
        StandardCopyOption.REPLACE_EXISTING
    )
}

try{

//Preprocessing: Query Solr
val sqlContext = new org.apache.spark.sql.SQLContext(sc)
val options = Map("zkhost"->"localhost:9983",
                  "collection"->"amazonBookReview",
                  "query"->"mystery",
                  "fields"->"reviewerID,asin",
                  "request_handler"->"/select")

val SJDF = spark.read.format("solr").options(options).load
SJDF.createOrReplaceTempView("SJDF")

val V1Amazon = spark.read.format("csv").option("header", "true").load(s"${V1Amazon}")
V1Amazon.createOrReplaceTempView("V1Amazon")

val result = spark.sql("""SELECT SJDF.reviewerID as i , SJDF.asin as j, overall as v
     | FROM SJDF, V1Amazon 
     | WHERE V1Amazon.reviewerID=SJDF.reviewerID AND V1Amazon.asin=SJDF.asin AND overall<2"""")

//Construct Matirx
constructMatirx (100000,50000,result,"X.mtx")

//Analysis
val ml = new MLContext(spark)
val outputPath = "results.out"
ml.setConfigProperty("sysml.cp.parallel.ops","true")
ml.setConfigProperty("sysml.optlevel","2")
ml.setConfigProperty("sysml.localtmpdir","systemml")


//DML Query
val dmlTextQuery =
  s"""
    | time = externalFunction(Integer i) return (Double B)
    |       implemented in (classname="org.apache.sysml.udf.lib.TimeWrapper", exectype="mem");
    |  timesRW = matrix(0.0, rows = 5, cols = 1)
    |  A  = read("${Syn9}", format="csv", header=FALSE, sep=",");
    |  B  = readMM("X.mtx");
    |  V1 = read("${Syn8}", format="csv", header=FALSE, sep=",");
    | for (ix in 1:5) {
    |   start = time(1)
    |   print("StartTime: "+start)
    |   res = (A%*%(t(V1)%*%V1))-(B%*%V1)
    |   while(FALSE){}
    |   print(as.scalar(res[1,1]))
    |   end = time(1)
    |   print("EndTime: "+end)
    |   pipTime = (end - start)/1000
    |   print ("Time:"+ pipTime)
    |   timesRW[ix,1] = pipTime  
    | }
    | timesRW = t(timesRW)
""".stripMargin
if (!Files.exists(Paths.get(outputPath))) {
File(outputPath).writeAll("-resutls-\n")
}
val scriptQ = dml(dmlTextQuery).out("timesRW")
val resQ = ml.execute(scriptQ)
val resultsRW = resQ.getTuple[Matrix]("timesRW")._1.to2DDoubleArray
File(outputPath).appendAll("AmazonHybridRW: ");
File(outputPath).appendAll(resultsQ(0).mkString(",") + '\n')
}
catch{
     case e: Exception =>{ 
        e.printStackTrace
        System.exit(0)
    }
}
System.exit(0)

