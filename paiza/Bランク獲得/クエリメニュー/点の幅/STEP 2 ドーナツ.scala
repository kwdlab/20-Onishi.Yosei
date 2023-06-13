import scala.io.StdIn._

object Main extends App {

    val HWN = readLine().split(" ").map(_.toInt)
    val H = HWN(0)
    val W = HWN(1)
    val N = HWN(2)
    val Cn = Array.ofDim[Int](H+1, W+1)

    for(i <- 1 to H){
        Cn(i) = Array(0) ++ readLine().split(" ").map(_.toInt)
    }

    def TransCumulativeSum(matrix: Array[Array[Int]]): Array[Array[Int]] = {
        val rows = matrix.length
        val cols = matrix(0).length
        val cumulativeSum = Array.ofDim[Int](rows, cols)

        for (i <- 0 until rows; j <- 0 until cols) {
            val fromLeft = if (j > 0) cumulativeSum(i)(j - 1) else 0
            val fromTop = if (i > 0) cumulativeSum(i - 1)(j) else 0
            val overlap = if (i > 0 && j > 0) cumulativeSum(i - 1)(j - 1) else 0

            cumulativeSum(i)(j) = matrix(i)(j) + fromLeft + fromTop - overlap
        }
        return cumulativeSum
    }
    def CalRegionSum(cumulativeSum: Array[Array[Int]], x1: Int, y1: Int, x2: Int, y2: Int): Int = {
        val sumA = cumulativeSum(x2)(y2)
        val sumB = if (x1 > 0) cumulativeSum(x1 - 1)(y2) else 0
        val sumC = if (y1 > 0) cumulativeSum(x2)(y1 - 1) else 0
        val sumD = if (x1 > 0 && y1 > 0) cumulativeSum(x1 - 1)(y1 - 1) else 0
        
        return sumA - sumB - sumC + sumD
    }

    val DATA = TransCumulativeSum(Cn)
    for (i <- 0 until N){
        val line = readLine().split(" ").map(_.toInt)
        val y = line(0)
        val x = line(1)
        val B = line(2)
        val S = line(3)
        var result = CalRegionSum(DATA, y-(B/2), x-(B/2), y+(B/2), x+(B/2)) - CalRegionSum(DATA, y-(S/2), x-(S/2), y+(S/2), x+(S/2))

        println(result)
    }
}
