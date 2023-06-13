import scala.io.StdIn._

object Main extends App {

    val Array(n, m) = readLine().trim().split(" ").map(_.toInt)

    println((1 to n).mkString(" "))
    println((1 to m).mkString(" "))
}