import scala.io.StdIn._

object Main extends App {

    val Array(k, l) = readLine().split(" ").map(_.toInt)
    val line = Array.fill(3)(readLine().split(" "))

    println(line(k-1)(l-1))
}