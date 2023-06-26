import scala.io.StdIn._

object Main extends App {

    val an = readLine().split(" ").map(_.toInt)
    println(s"${an.max} ${an.min}")
}
