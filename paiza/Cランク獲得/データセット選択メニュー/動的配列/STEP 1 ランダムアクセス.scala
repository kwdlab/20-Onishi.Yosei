import scala.io.StdIn._

object Main extends App {

    val Array(n, m) = readLine().split(" ").map(_.toInt)
    val a = readLine().split(" ").map(_.toInt)

    println(a(m-1))
}
