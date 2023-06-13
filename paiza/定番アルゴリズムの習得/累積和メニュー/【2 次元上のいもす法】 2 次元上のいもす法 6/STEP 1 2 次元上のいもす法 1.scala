import scala.io.StdIn._

object Main extends App {

    val n = 5 + 1
    val m = 5 + 1
    val q = 5
    val l = Array(Array(1, 1), Array(2, 2), Array(3, 3), Array(1, 3), Array(3, 1))
    val r = Array(Array(3, 3), Array(4, 4), Array(5, 5), Array(3, 5), Array(5, 3))
    val a = Array.ofDim[Int](n, m)

    def imos2D(a: Array[Array[Int]], l: Array[Array[Int]], r: Array[Array[Int]]): Array[Array[Int]] = {
        for ((i, j) <- l.zip(r)){
            a(i(0)-1)(i(1)-1) = a(i(0)-1)(i(1)-1) + 1
            a(j(0))(j(1)) = a(j(0))(j(1)) + 1
        }
        for ((i, j) <- l.zip(r)){
            a(i(0)-1)(j(1)) = a(i(0)-1)(j(1)) - 1
            a(j(0))(i(1)-1) = a(j(0))(i(1)-1) - 1
        }
        return a
    }

    def make2DCumulativeSum(a: Array[Array[Int]], n: Int, m: Int): Array[Array[Int]] = {
        val s = Array.ofDim[Int](n+1, m+1)
        for (i <- 0 until n; j <- 0 until m){
            s(i+1)(j+1) = s(i)(j+1) + s(i+1)(j) - s(i)(j) + a(i)(j)
        }
        return s
    }

    val board = imos2D(a, l, r)
    val s = make2DCumulativeSum(board, n, m)
    val result = s.flatten.max
    println(result)
}
