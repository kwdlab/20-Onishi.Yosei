import scala.io.StdIn._

object Main extends App {

    val n = readLine().toInt
    val a = readLine().split(" ").map(_.toInt)

    val even = a.count(_ % 2 == 0)
    val oval = a.count(_ % 2 != 0)
    println(s"${even} ${oval}")
}
