import scala.io.StdIn._

object Main extends App {

    val Array(n, t) = readLine().trim().split(" ").map(_.toInt)
    val lr = Array.fill(n)(readLine().trim().split(" ").map(_.toLong))
    val dist = readLine().trim().toLong

    println(binarySearch(A, n, k))

    def binarySearch(A: Array[Double], n: Int, target: Int): Double = {
        var left = 0.toDouble
        var right = 10001.toDouble
        for (_ <- 0 until 100){
            val mid = ((left + right) / 2.0).toDouble
            var num = 0
            for (a <- A){
                num = num + (a/mid).toInt
            }
            if (num < target){
                right = mid 
            } else {
                left = mid
            }
        }
        return left
    }
}
//解答例使用済み