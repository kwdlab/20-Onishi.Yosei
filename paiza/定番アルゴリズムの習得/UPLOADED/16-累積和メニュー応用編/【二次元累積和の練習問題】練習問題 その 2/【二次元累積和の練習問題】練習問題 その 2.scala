import scala.io.StdIn._

object Main extends App {

    val Array(n, p) = readLine().split(" ").map(_.toInt)
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

    def maxSearch(s: Array[Array[Int]], n: Int, m: Int, p: Int): Int = {
        var maxTmp = 0
        for (sx <- 0 until n; sy <- 0 until n; ex <- 0 until n; ey <- 0 until n){
            val tmp = use2DCumulativeSum(s, sx, sy, ex, ey)
            val area = (ex - sx + 1) * (ey - sy + 1)
            if (area <= p){
                maxTmp = maxTmp.max(tmp)
            }
        }
        return maxTmp
    }

    val s = make2DCumulativeSum(board, n, n)
    val result = maxSearch(s, n, n, p)
    println(result)
}
//解答例使用済み