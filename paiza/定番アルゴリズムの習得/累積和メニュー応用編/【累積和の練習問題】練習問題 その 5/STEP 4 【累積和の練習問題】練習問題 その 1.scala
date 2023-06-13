import scala.io.StdIn._

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
    var maxTmp = 0
    var boardNum = 0
    for (i <- 1 until n+1){
        boardNum = boardNum + s(i)
        maxTmp = maxTmp.max(boardNum)
    }
    println(maxTmp)
}
//解答例使用済み