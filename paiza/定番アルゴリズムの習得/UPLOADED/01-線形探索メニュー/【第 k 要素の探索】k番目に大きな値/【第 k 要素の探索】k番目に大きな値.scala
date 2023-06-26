import scala.io.StdIn._

object Main extends App {

    val n = readLine().toInt
    val a = readLine().split(" ").map(_.toLong)
    val k = readLine().toInt

    println(a.sorted.reverse(k-1))
}