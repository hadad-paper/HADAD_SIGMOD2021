import scala.math._
import java.nio.file.{Paths, Files}
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf
import org.apache.spark.rdd._
import breeze.linalg.*
import breeze.{math => bMath,
               numerics => bNum,
               linalg => bAlg}
import breeze.linalg.{Vector => bVector,
                      Matrix => bMatrix,
                      SparseVector => bSparseVector,
                      DenseVector => bDenseVector,
                      CSCMatrix => bSparseMatrix,
                      DenseMatrix => bDenseMatrix}
import org.apache.spark.storage.StorageLevel._
import org.apache.spark.mllib.linalg._
import org.apache.spark.mllib.linalg
import org.apache.spark.ml.{linalg => alg}
import org.apache.spark.mllib.random.RandomRDDs._
import org.apache.spark.mllib.linalg.distributed._
import org.apache.spark.sql._
import scala.tools.nsc.io._
import scala.io.Source
import java.util.Random

val outputPath = "results.out"
if (!Files.exists(Paths.get(outputPath))) {
    File(outputPath).writeAll("-Results-\n")
}
def readDMM(matirxName: String, sc: SparkContext) : IndexedRowMatrix = {
        val M = sc.textFile(matirxName, 500).zipWithIndex().
                         map(
                            tup => new IndexedRow(
                                tup._2.toInt,
                                new DenseVector(tup._1.split(",").
                                    map(_.toDouble))))
        val BM = new IndexedRowMatrix(M)
        BM.rows.persist(MEMORY_AND_DISK_SER)
        return BM
}
//Breaze Utils
def as_breeze(v: linalg.DenseVector) : bDenseVector[Double] = {
    return new bDenseVector[Double](v.values)
}

def from_breeze(v: bDenseVector[Double]) : linalg.DenseVector = {
    return as_dense(Vectors.dense(v.data))
}

def as_breeze(m: linalg.DenseMatrix) : bDenseMatrix[Double] = {
    return new bDenseMatrix(m.numRows, m.numCols, m.toArray)
}

def from_breeze(m: bDenseMatrix[Double]) : linalg.DenseMatrix = {
    return as_dense(Matrices.dense(m.rows, m.cols, m.toDenseMatrix.data))
}

def vectorize(M: Matrix) : DenseVector = {
    return as_dense( Vectors.dense( M.toArray ) )
}

def as_dense(M: Matrix) : DenseMatrix = {
    return M.asInstanceOf[DenseMatrix]
}

def as_dense(v: Vector) : DenseVector = {
    return v.asInstanceOf[DenseVector]
}

def test05(A: DenseMatrix, B: DenseMatrix, V1: DenseVector) : DenseVector= {
    return  from_breeze(as_breeze(A)+as_breeze(B)).multiply(V1)
}

val scriptArgs = sc.getConf.get("spark.driver.args").split(",")
val A = readDMM(scriptArgs(0), sc).toBlockMatrix(100,100)
A.blocks.count
val B = readDMM(scriptArgs(1), sc).toBlockMatrix(100,100)
B.blocks.count
val V1 = as_dense(vectorize(Matrices.rand(100, 1, new Random())))


val AD = A.toLocalMatrix.asInstanceOf[DenseMatrix]
val BD = B.toLocalMatrix.asInstanceOf[DenseMatrix]

val times = Array[Double](0,0,0,0,0,0)
for (ix <- 0 to 5) {
    val start = System.nanoTime()
    val res =test05(AD,BD,V1)
    println(res.apply(1))
    val stop = System.nanoTime()
    times(ix) = (stop - start) / 1e9
}
File(outputPath).appendAll("P1.4(Q"+scriptArgs(0)+"): ");
File(outputPath).appendAll(times.mkString(",") + '\n')
System.exit(0)

