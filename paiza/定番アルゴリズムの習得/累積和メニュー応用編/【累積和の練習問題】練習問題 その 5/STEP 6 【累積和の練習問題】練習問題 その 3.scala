import scala.io.StdIn._
import scala.math._

object Main extends App {

    val n = readLine().toInt
    val an = readLine().split(" ").map(_.toInt)

    def makeCumulativeSum(a: Array[Int], n: Int): Array[Int] = {
        val s = Array.ofDim[Int](n+1)
        for (i <- 0 until n+1){
            if (i == 0){
                s(i) = 0
            } else {
                s(i) = a(i-1) + s(i-1)
            }
        }
        return s
    }

    def useCumulativeSum(s: Array[Int], l: Int, r: Int): Int = {
        return (s(r+1)-s(l))
    }

    def maxCumulativeSum(s: Array[Int], k: Int): Int = {
        var max = 0
        for (i <- 0 until s.length-k){
            max = max.max(s(i+k)-s(i))
        }
        return max
    }

    val s = makeCumulativeSum(an, n)
    var minTmp = 1000000
    for (k <- 0 until n){
        val tmp = abs(s(k+1) - (s(n)-s(k+1)))
        minTmp = minTmp.min(tmp)
    }
    val result = minTmp
    println(result)
}
//解答例使用済み