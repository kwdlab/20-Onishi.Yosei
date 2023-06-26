import scala.io.StdIn._

object Main extends App {
    val n = readLine().toInt
    val An = readLine().split(" ").map(_.toInt)

    println(s"${An.max} ${An.min}")
}