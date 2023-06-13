import scala.io.StdIn._
import scala.math._

object Main extends App {
    val N = readLine().toInt
    val a = readLine().split(" ").map(_.toInt)

    val left = Array.fill(N + 1)(0)
    val right = Array.fill(N + 1)(0)

    for (i <- 0 until N) {
        left(i + 1) = Math.max(left(i), a(i))
        right(i + 1) = Math.max(right(i), a(N - i - 1))
    }

    for (i <- 1 until N - 1) {
        println(Math.min(left(i), right(N - i - 1)))
    }
}

//解答例使用済み
//断念