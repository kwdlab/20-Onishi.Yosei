import scala.io.StdIn._

object Main extends App {

    val Array(n, a, b, mod) = readLine().split(" ").map(_.toInt)

    for (_ <- 0 until n) {
        val x = readLine().toInt
        println((a*x + b) % mod)
    }
}