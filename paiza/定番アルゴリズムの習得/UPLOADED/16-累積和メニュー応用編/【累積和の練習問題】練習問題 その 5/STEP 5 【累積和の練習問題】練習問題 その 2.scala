import scala.io.StdIn._

object Main extends App {

    val Array(n, a, b) = readLine().split(" ").map(_.toInt)
    val str = readLine().split("")
    val an = Array.ofDim[Int](n)
    for (i <- 0 until n - 2) {
        if (str(i) == "p" && str(i + 1) == "i" && str(i + 2) == "z") {
            an(i) = 1
        } else {
            an(i) = 0
        }
    }

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
    val result = useCumulativeSum(s, a-1, b-3)
    println(result)
}
//解答例使用済み