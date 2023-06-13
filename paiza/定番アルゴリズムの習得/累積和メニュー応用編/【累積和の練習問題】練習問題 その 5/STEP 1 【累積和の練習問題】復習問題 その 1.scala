import scala.io.StdIn._

object Main extends App {

    val Array(n, a, b) = readLine().split(" ").map(_.toInt)
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

    val s = makeCumulativeSum(an, n)
    val result = useCumulativeSum(s, a, b)
    println(result)
}
