import scala.io.StdIn._

object Main extends App {

    val Array(n, a, b) = readLine.split(" ").map(_.toInt)
    val line = readLine.split(" ").map(_.toInt)

    println(line.slice(a-1, b).sum)
}
