import scala.io.StdIn._

object Main extends App {

    val q = readLine().toInt
    val an = Array.ofDim[Int](1010)

    for (i <- 0 until an.length){
        if ((i)%3 == 0 && (i)%5 == 0) {
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

    for (i <- 0 until q){
        val Array(l, r) = readLine().split(" ").map(_.toInt)
        val s = makeCumulativeSum(an, an.length)
        val result = useCumulativeSum(s, l, r)
        println(result)
    }
}
//解答例使用済み