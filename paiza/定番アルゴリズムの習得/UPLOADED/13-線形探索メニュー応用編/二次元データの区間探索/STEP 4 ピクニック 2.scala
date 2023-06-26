import scala.io.StdIn._

object Main extends App {

    val Array(n, m, k) = readLine().split(" ").map(_.toInt)
    val a = Array.fill(n)(readLine().split(" ").map(_.toInt))

    def maxValue(): Unit = {
        val max = (for {
            i <- 0 until n - k + 1
            j <- 0 until m - k + 1
        } yield {
        val sum = (for {
            y <- 0 until k
            x <- 0 until k
        } yield a(i + y)(j + x)).sum
        sum
        }).max

        println(max)
    }

    maxValue()
}