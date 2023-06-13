import scala.io.StdIn._

object Main extends App {

    val n = readLine().trim()

    println(n.reverse.grouped(3).mkString(",").reverse)
}