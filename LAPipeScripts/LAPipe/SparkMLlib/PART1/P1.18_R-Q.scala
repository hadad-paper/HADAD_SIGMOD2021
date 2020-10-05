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

//Functions
def readSMM(matirxName: String, sc: SparkContext) : IndexedRowMatrix = {
      val M = sc.textFile(matirxName).zipWithIndex()
      val s  = M.filter(tup => tup._2 == 1).map(dim=> dim._1.trim).first
      val dim = s.split(" ")
      val matrix = M.filter(tup => tup._2 > 1).
           map(tup => tup._1.trim.split(" ")).
           map(row => new MatrixEntry(
               row(0).toLong, row(1).toLong, row(2).toDouble))
    val SM = new CoordinateMatrix( matrix, dim(0).toLong, dim(1).toLong )
    SM.entries.persist(MEMORY_AND_DISK_SER)
        return SM.toIndexedRowMatrix()
}

def to_dense(M: bMatrix[Double]) : bDenseMatrix[Double] = {
    return M.asInstanceOf[bDenseMatrix[Double]]
}

def to_sparse(M: bMatrix[Double]) : bSparseMatrix[Double] = {
    return M.asInstanceOf[bSparseMatrix[Double]]
}
def as_breeze(m: linalg.Matrix) : bMatrix[Double] = m match {
    case m: linalg.DenseMatrix =>{
        return new bDenseMatrix(m.numRows, m.numCols, m.toArray)
    }
    case m: linalg.SparseMatrix =>
        return new bSparseMatrix(
            m.values, m.numRows, m.numCols,
            m.colPtrs, m.numActives, m.rowIndices)
}
def as_breeze(v: linalg.Vector) : bVector[Double] = v match {
    case v: linalg.SparseVector =>
        return new bSparseVector[Double](v.indices, v.values, v.size)
    case v: linalg.DenseVector  =>
        return new bDenseVector[Double](v.values)
}
def as_breeze_D(m: linalg.DenseMatrix) : bDenseMatrix[Double] = {
    return new bDenseMatrix(m.numRows, m.numCols, m.toArray)
}


def from_breeze(m: bMatrix[Double]) : linalg.Matrix = m match {
        case m: bDenseMatrix[Double] =>
            return Matrices.dense(m.rows, m.cols, m.toDenseMatrix.data)
        case m: bSparseMatrix[Double] =>
            return Matrices.sparse(m.rows, m.cols,
                    m.colPtrs, m.rowIndices, m.data)
}

def from_breeze(v: bVector[Double]) : linalg.Vector = v match {
    case v: bSparseVector[Double] =>
        return Vectors.sparse(v.length, v.activeIterator.toSeq)
    case v: bDenseVector[Double] =>
        return Vectors.dense(v.data)
}

def query(A: DenseMatrix):Double = {
    return bAlg.sum(bAlg.sum(as_breeze_D(A)(::,*)))
}

// def query(A: SparseMatrix):linalg.Vector = {
//     val AD = A.transpose
//     return  from_breeze(bAlg.sum(as_breeze(AD)(*,::)))
// }

val scriptArgs = sc.getConf.get("spark.driver.args").split(",")
val A = readSMM(scriptArgs(0), sc).toBlockMatrix(100,100)
A.blocks.count

val AS = A.toLocalMatrix.asInstanceOf[DenseMatrix].toSparse.toDense

val outputPath = "results.out"
if (!Files.exists(Paths.get(outputPath))) {
    File(outputPath).writeAll("-Results-\n")
}
//Query
val times = Array[Double](0,0,0,0,0,0)
for (ix <- 0 to 5) {
    val start = System.nanoTime()
    val res =query(AS)
    println(res)
    val stop = System.nanoTime()
    times(ix) = (stop - start) / 1e9
}

File(outputPath).appendAll("P1.18(Q"+scriptArgs(0)+"): ");
File(outputPath).appendAll(times.mkString(",") + '\n')

System.exit(0)

