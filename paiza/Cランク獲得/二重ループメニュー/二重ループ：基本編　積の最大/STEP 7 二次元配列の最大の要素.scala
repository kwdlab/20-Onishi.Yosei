import scala.io.StdIn._

object Main extends App {

    val Array(n, k) = readLine().split(" ").map(_.toInt)
    val a = Array.fill(n)(readLine().split(" ").map(_.toInt).max)

    println(a.max)
}