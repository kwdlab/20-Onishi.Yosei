import scala.io.StdIn._

object Main extends App {

    val Array(n, m) = readLine().trim().split(" ").map(_.toInt)
    val line = readLine().trim().split(" ").map(_.toInt)

    println(line.count(_ == n))
}
