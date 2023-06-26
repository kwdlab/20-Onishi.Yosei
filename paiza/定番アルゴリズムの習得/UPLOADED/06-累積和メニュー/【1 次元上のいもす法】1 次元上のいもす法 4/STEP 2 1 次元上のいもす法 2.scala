import scala.io.StdIn._

object Main extends App {

    val a = Array(0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
    val n = a.length
    val l = Array.ofDim[Int](5)
    val r = Array.ofDim[Int](5)

    for (i <- 0 until 5){
        val Array(x, y) = readLine().split(" ").map(_.toInt)
        l(i) = x
        r(i) = y
    }

    def imos(a: Array[Int], l: Array[Int], r: Array[Int]): Array[Int] = {
        for (i <- l){
            a(i-1) = a(i-1) + 1
        }
        for (j <- r){
            a(j) = a(j) - 1
        }
        return a
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

    val board = imos(a, l, r)
    val s = makeCumulativeSum(board, n)
    val result = s.max
    println(result)
}
