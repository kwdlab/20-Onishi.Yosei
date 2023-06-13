import scala.io.StdIn._

object Main extends App {

    val Array(n, m) = readLine().trim().split(" ").map(_.toInt)
    println(String.format(s"%${m}s", n).replace(" ", " "))
}