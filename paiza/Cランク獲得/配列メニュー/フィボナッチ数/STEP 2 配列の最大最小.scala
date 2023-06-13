import scala.io.StdIn._

object Main extends App {

    val num = readLine().toInt
    val line = readLine().split(" ").map(_.toInt)
    val result = line.sorted

    println(s"${result.max} ${result.min}")
}
