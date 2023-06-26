import scala.io.StdIn._

object Main extends App {

    val n = readLine().toInt
    val a = readLine().split(" ").map(_.toLong)

    println(a.sorted.reverse(1))
}