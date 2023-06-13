import scala.io.StdIn._

object Main extends App {

    val line = readLine().split(" ")
    val n = line(0).toInt
    val x = line(1).toInt
    val y = line(2).toInt
    val c = line(3).toString
    val str = readLine().split("")
    val an = str.map(x => if(x == c){ 1 } else { 0 })

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
        return (s(r)-s(l-1))
    }

    def maxCumulativeSum(s: Array[Int], k: Int): Int = {
        var max = 0
        for (i <- 0 until s.length-k){
            max = max.max(s(i+k)-s(i))
        }
        return max
    }

    val s = makeCumulativeSum(an, n)
    val result = useCumulativeSum(s, x, y)
    println(result)
}
