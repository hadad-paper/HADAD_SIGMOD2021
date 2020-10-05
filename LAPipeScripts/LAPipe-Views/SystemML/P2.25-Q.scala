import scala.math._
import java.nio.file.{Paths, Files}
import org.apache.sysml.api.mlcontext._
import org.apache.sysml.api.mlcontext.ScriptFactory._
import org.apache.sysml.api.mlcontext.MatrixFormat._
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf
import scala.io.Source
import org.apache.spark.sql._
import scala.tools.nsc.io._
import scala.collection.immutable._
import org.apache.spark.storage.StorageLevel._
import org.apache.spark.ml.{linalg => alg}
import org.apache.spark.mllib.{linalg => malg}
import org.apache.spark.mllib.linalg.distributed._

val ml = new MLContext(spark)
val outputPath = "results.out"

 ml.setConfigProperty("sysml.cp.parallel.ops","true")
 ml.setConfigProperty("sysml.optlevel","2")
 ml.setConfigProperty("sysml.localtmpdir","systemml")
 ml.setExplain(true)
 ml.setExplainLevel(MLContext.ExplainLevel.RUNTIME)
 ml.setExecutionType(MLContext.ExecutionType.DRIVER)
 ml.setStatistics(true)
try{
if (!Files.exists(Paths.get(outputPath))) {
File(outputPath).writeAll("-results-\n")
}
val scriptArgs = sc.getConf.get("spark.driver.args").split(",")

val A = scriptArgs(0)
val B = scriptArgs(1)
val V1 = scriptArgs(2)


//DML Query
val dmlTextQuery =
  s"""
    | time = externalFunction(Integer i) return (Double B)
    |       implemented in (classname="org.apache.sysml.udf.lib.TimeWrapper", exectype="mem");
    |  timesQ = matrix(0.0, rows = 5, cols = 1)
    |  A  = read("${A}", format="csv", header=FALSE, sep=",");
    |  B  = readMM("${B}");
    |  V1 = read("${V1}", format="csv", header=FALSE, sep=",");
    |  view = A%*%t(V1)
    |  for (ix in 1:5) {
    |   start = time(1)
    |   print("StartTime: "+start)
    |   res = (A%*%t(V1)-B)%*%V1
    |   while(FALSE){}
    |   print(as.scalar(res[1,1]))
    |   end = time(1)
    |   print("EndTime: "+end)
    |   pipTime = (end - start)/1000
    |   print ("Time:"+ pipTime)
    |   timesQ[ix,1] = pipTime
    | }
    | timesQ = t(timesQ)
""".stripMargin
val scriptQ = dml(dmlTextQuery).out("timesQ")
val resQ = ml.execute(scriptQ)
val resultsQ = resQ.getTuple[Matrix]("timesQ")._1.to2DDoubleArray
File(outputPath).appendAll("P2.25Q("+scriptArgs(0)+"):");
File(outputPath).appendAll(resultsQ(0).mkString(",") + '\n')
}
catch{
     case e: Exception =>{ 
        e.printStackTrace
        System.exit(0)
    }
}
System.exit(0)
