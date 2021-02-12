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
val C = scriptArgs(4)
val X = scriptArgs(5)

println("*************1-9Q**********")
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
                                       curr_careunit='CCU' and  row_id!=6608 and 
                                       subject_id <=48612 and 
                                       row_id<= 35000""")

val rRelationDataDF = rRelationData.dropDuplicates()
//Construct N Matirx
constructSparseMatirx (48612,35000,rRelationDataDF,"N.mtx");
//Analysis
try{
val ml = new MLContext(spark)
val outputPath = "Exp40K/Q1-9/results-Q.out"
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
    |  C = read("${C}", format="csv", header=FALSE, sep=",");
    |  X = read("${X}", format="csv", header=FALSE, sep=",");
    | for (ix in 1:3) {
    |   start = time(1)
    |   start2 = time(1)
    |   print("StartTime: "+start2)
    |   print("StartTime: "+start)
    |   NF = ifelse(N==1,N,0)
    |   while(FALSE){}
    |   print(as.scalar(NF[3155,400]))
    |   end=time(1)
    |	  print("StartTime: "+end)
    |   print("TimeS: "+ ((end-start)/1000))
    |   res = X*sum(t(colSums(C))*rowSums(M))+ NF
    |   while(FALSE){}
    |   print(as.scalar(res[12,40]))
    |   end2 = time(1)
    |   print("StartTime: "+end2)
    |   pipTime = (end2 - start2)/1000
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
