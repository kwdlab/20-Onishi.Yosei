import scala.io.StdIn._

object Main extends App {

    val Array(n, m, k, l) = readLine().split(" ").map(_.toInt)
    val line = Array.fill(n)(readLine().split(" "))

    println(line(k-1)(l-1))
}