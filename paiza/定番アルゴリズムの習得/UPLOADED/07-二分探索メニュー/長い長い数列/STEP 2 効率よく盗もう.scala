import scala.io.StdIn._

object Main extends App {

    val Array(n, k) = readLine().split(" ").map(_.toInt)
    val W = readLine().split(" ").map(_.toDouble)
    val V = readLine().split(" ").map(_.toDouble)

    println(binarySearch(W, V, n, k))

    def binarySearch(W: Array[Double], V: Array[Double], n: Int, target: Int): Double = {
        var left = 0.toDouble
        var right = 5001.toDouble
        for (_ <- 0 until 100){
            val mid = ((left + right) / 2.0).toDouble

            var tmp = Array.ofDim[Double](n)
            for (i <- 0 until n){
                tmp(i) = V(i) - W(i)*mid
            }

            if (tmp.sorted.reverse.take(k).sum >= 0){
                left = mid 
            } else {
                right = mid
            }
        }
        return left
    }
}
//解答例使用済み