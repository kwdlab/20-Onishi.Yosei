import scala.io.StdIn._

object Main extends App {

    val n = readLine().trim().toInt

    println((1 to n/2).mkString(" "))
    println((n/2 + 1 to n).mkString(" "))
}