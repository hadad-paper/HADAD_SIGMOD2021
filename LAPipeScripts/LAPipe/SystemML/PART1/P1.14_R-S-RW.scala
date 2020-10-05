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
ml.setConfigProperty("sysml.optlevel","4")
ml.setConfigProperty("sysml.localtmpdir","systemml")
ml.setExplain(true)
ml.setExplainLevel(MLContext.ExplainLevel.RUNTIME)
ml.setExecutionType(MLContext.ExecutionType.DRIVER)
ml.setStatistics(true)

if (!Files.exists(Paths.get(outputPath))) {
File(outputPath).writeAll("-RESULTS-\n")
}

try {
val scriptArgs = sc.getConf.get("spark.driver.args").split(",")
val M = scriptArgs(0)
val N = scriptArgs(1)

    //DML Query
val dmlTextQuery =
  s"""
    | time = externalFunction(Integer i) return (Double B)
    |       implemented in (classname="org.apache.sysml.udf.lib.TimeWrapper", exectype="mem");
    |  timesRW = matrix(0.0, rows = 5, cols = 1)
    |  M = readMM("${M}");
    |  N = read("${N}", format="csv", header=FALSE, sep=",");
    | for (ix in 1:5) {
    |   start = time(1)
    |   print("StartTime: "+start)
    |   res = sum(t(colSums(M))*rowSums(N))
    |   while(FALSE){}
    |   print(res)
    |   end = time(1)
    |   print("EndTime: "+end)
    |   pipTime = (end - start)/1000
    |   print ("Time:"+ pipTime)
    |   timesRW[ix,1] = pipTime
    | }
    | timesRW = t(timesRW)
""".stripMargin
val scriptQ = dml(dmlTextQuery).out("timesRW")
val resQ = ml.execute(scriptQ)
val resultsRW = resQ.getTuple[Matrix]("timesRW")._1.to2DDoubleArray
File(outputPath).appendAll("P1.14RW("+scriptArgs(0)+"):");
File(outputPath).appendAll(resultsRW(0).mkString(",") + '\n');
  } catch {
    case e: Exception => {
        e.printStackTrace
        System.exit(0)
    } 
  }

System.exit(0)

