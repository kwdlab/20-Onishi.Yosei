import scala.io.StdIn._

object Main extends App {

    val Array(x, y) = readLine().split(" ").map(_.toInt)

    println(s"${y} ${x}")
}