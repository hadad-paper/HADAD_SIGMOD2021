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
val patients = scriptArgs(0)
val admissions = scriptArgs(1)
val services = scriptArgs(2)
val callouts = scriptArgs(3)
val U1 = scriptArgs(4)
val V1 = scriptArgs(5)
val X = scriptArgs(6)

println("************1-1Q***********")

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


//Preprocessing 
val sqlContext = new org.apache.spark.sql.SQLContext(sc)

// Read-base tables
val patientsDF = sqlContext.read.format("csv").option("header", "true").load(s"${patients}");
patientsDF.createOrReplaceTempView("patients")

val admissionsDF = sqlContext.read.format("csv").option("header", "true").load(s"${admissions}")
admissionsDF.createOrReplaceTempView("admissions")

val M1 = spark.sql("SELECT * FROM patients, admissions WHERE admissions.subject_id=patients.subject_id")
val M2 = M1.drop("subject_id")

constructMatirx (M2,"M.csv");

val servicesDF = sqlContext.read.format("csv").option("header", "true").load(s"${services}");
servicesDF.createOrReplaceTempView("services")

val calloutsDF = sqlContext.read.format("csv").option("header", "true").load(s"${callouts}")
calloutsDF.createOrReplaceTempView("callouts")

val rRelationData = spark.sql("""SELECT subject_id, row_id, callout_outcome_cat 
                                 FROM callouts, services 
                                 WHERE services.subject_id_s=callouts.subject_id AND 
                                       callouts.hadm_id=services.hadm_id AND 
                                       curr_careunit='CCU' AND 
                                       subject_id<=28000 AND 
                                       row_id<=35000 AND 
                                       row_id!=6608""")

val rRelationDataDF = rRelationData.dropDuplicates()
//Construct N Matirx
constructSparseMatirx (28000,35000,rRelationDataDF,"N.mtx");

//Analysis
try{
val ml = new MLContext(spark)
val outputPath = "Exp20K/Q1-1/results-Q.out"
ml.setConfigProperty("sysml.cp.parallel.ops","true")
ml.setConfigProperty("sysml.optlevel","2")
ml.setConfigProperty("sysml.localtmpdir","systemml")

//DML Query
val dmlTextQuery =
  s"""
    | time = externalFunction(Integer i) return (Double B)
    |       implemented in (classname="org.apache.sysml.udf.lib.TimeWrapper", exectype="mem");
    |  timesQ = matrix(0.0, rows = 5, cols = 1)
    |  timesS = matrix(0.0, rows = 5, cols = 1)
    |  M  = read("M.csv", format="csv", header=FALSE, sep=",");
    |  N  = readMM("N.mtx");
    |  V1 = read("${V1}", format="csv", header=FALSE, sep=",");
    |  U1 = read("${U1}", format="csv", header=FALSE, sep=",");
    |  X = read("${X}", format="csv", header=FALSE, sep=",");
    | for (ix in 1:5) {
    |   start = time(1)
    |   start2 = time(1)
    |   print("StartTime: "+start)
    |   print("StartTime: "+start2)
    |   NF = ifelse(N==1,N,0)
    |   print(as.scalar(NF[1000,400]))
    |   end = time(1)
    |   print("StartTime: "+end)
    |   timesS[ix,1] = ((end-start)/1000)
    |   res =rowSums(X%*%M) + (((U1%*%t(V1) ) + t(NF))%*%V1)
    | while(FALSE){}
    |   print(as.scalar(res[1,1]))
    |   print(as.scalar(res[2,1]))
    |   print(as.scalar(res[3,1]))
    |   print(as.scalar(res[20,1]))
    |   print(as.scalar(res[100,1]))
    |   print(as.scalar(res[500,1]))
    |   end2 = time(1)
    |   print("StartTime: "+end2)
    |   pipTime = (end2 - start2)/1000
    |   print ("TimeQ:"+ pipTime)
    |   timesQ[ix,1] = pipTime
    | }
    | timesS = t(timesS)
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
val scriptQS = dml(dmlTextQuery).out("timesS")
val resQS = ml.execute(scriptQS)
val resultsS = resQS.getTuple[Matrix]("timesS")._1.to2DDoubleArray
File(outputPath).appendAll("MIMICHybridS:");
File(outputPath).appendAll(resultsS(0).mkString(",") + '\n')
}
catch{
     case e: Exception =>{ 
        e.printStackTrace
        System.exit(0)
    }
}
System.exit(0)
