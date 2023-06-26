import scala.io.StdIn._

object Main extends App {

    val Array(n, m) = readLine().split(" ").map(_.toInt)
    val board = Array.ofDim[Int](n, m)
    val Array(a, b, c, d) = readLine().split(" ").map(_.toInt)

    for (i <- 0 until n){
        board(i) = readLine().split(" ").map(_.toInt)
    }
    
    val sx = b
    val sy = a
    val gx = d
    val gy = c

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

    val s = make2DCumulativeSum(board, n, m)
    val result = use2DCumulativeSum(s, sx, sy, gx, gy)
    println(result)
}
