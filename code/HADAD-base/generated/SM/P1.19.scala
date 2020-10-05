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
val dmlTextQuery ="""c_1=read("V7.csv", format="csv", header=FALSE, sep=",")
RW1=(t(c_1))"""
val scriptQ=dml(dmlTextQuery)
val resQ = ml.execute(scriptQ)