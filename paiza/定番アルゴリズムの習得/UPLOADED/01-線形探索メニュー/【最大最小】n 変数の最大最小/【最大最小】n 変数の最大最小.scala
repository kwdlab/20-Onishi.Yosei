import scala.io.StdIn._

object Main extends App {

    val n = readLine().toInt
    val an = readLine().split(" ").map(_.toInt)
    println(s"${an.max} ${an.min}")
}
