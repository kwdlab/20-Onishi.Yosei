import scala.io.StdIn._

object Main extends App {

    val n = 5
    val m = 5
    val l1 = Array(1, 2, 3, 4, 5)
    val l2 = Array(2, 3, 4, 5, 6)
    val l3 = Array(3, 4, 5, 6, 7)
    val l4 = Array(4, 5, 6, 7, 8)
    val l5 = Array(5, 6, 7, 8, 9)
    val board = Array(l1, l2, l3, l4, l5)
    
    val sx = 1
    val sy = 1
    val gx = 3
    val gy = 3

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
