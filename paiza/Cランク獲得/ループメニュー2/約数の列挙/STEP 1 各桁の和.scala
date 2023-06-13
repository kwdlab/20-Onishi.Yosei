import scala.io.StdIn._

object Main extends App {

    val n = readLine().trim().split("").map(_.toInt)
    println(n.sum)
}