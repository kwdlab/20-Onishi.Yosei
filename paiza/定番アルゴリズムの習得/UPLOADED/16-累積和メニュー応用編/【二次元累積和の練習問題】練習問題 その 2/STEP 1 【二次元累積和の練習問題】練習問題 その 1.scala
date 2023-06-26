import scala.io.StdIn._

object Main extends App {

    val Array(n, w, h) = readLine().split(" ").map(_.toInt)
    val board = Array.ofDim[Int](n, n)

    for (i <- 0 until n){
        board(i) = readLine().split(" ").map(_.toInt)
    }

    def make2DCumulativeSum(a: Array[Array[Int]], n: Int, m: Int): Array[Array[Int]] = {
        val s = Array.ofDim[Int](n+1, m+1)
        for (i <- 0 until n; j <- 0 until m){
            s(i+1)(j+1) = s(i)(j+1) + s(i+1)(j) - s(i)(j) + a(i)(j)
        }
        return s
    }

    def use2DCumulativeSum(s: Array[Array[Int]], sx: Int, sy: Int, gx: Int, gy: Int): Int = {
        return (s(gy+1)(gx+1) - s(sy)(gx+1) - s(gy+1)(sx) + s(sy)(sx))
    }

    def maxSearch(s: Array[Array[Int]], n: Int, m: Int, w: Int, h: Int): Int = {
        var maxTmp = 0
        for (y <- 0 until n-h+1; x <- 0 until m-w+1){
            maxTmp = maxTmp.max(use2DCumulativeSum(s, x, y, x+w-1, y+h-1))
        }
        return maxTmp
    }

    val s = make2DCumulativeSum(board, n, n)
    val result = maxSearch(s, n, n, w, h)
    println(result)
}
//解答例使用済み