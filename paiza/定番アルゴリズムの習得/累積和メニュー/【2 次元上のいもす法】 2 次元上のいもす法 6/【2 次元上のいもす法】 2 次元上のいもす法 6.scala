import scala.io.StdIn._

object Main extends App {

    val Array(tmp1, tmp2, q) = readLine().split(" ").map(_.toInt)
    val n = tmp1 + 5
    val m = tmp2 + 5
    val l = Array.ofDim[Int](q, 2)
    val r = Array.ofDim[Int](q, 2)
    val a = Array.ofDim[Int](n, m)

    for (i <- 0 until q){
        val Array(a, b, c, d) = readLine().split(" ").map(_.toInt)
        l(i) = Array(a, b)
        r(i) = Array(c, d)
    }

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
