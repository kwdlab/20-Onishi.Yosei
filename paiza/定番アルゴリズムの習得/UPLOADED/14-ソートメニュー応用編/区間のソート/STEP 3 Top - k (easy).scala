import scala.io.StdIn._

object Main extends App {
    val Array(n, k) = readLine().split(" ").map(_.toInt)
    val An = readLine().split(" ").map(_.toInt)

    println(An.sorted.reverse(k-1))
}