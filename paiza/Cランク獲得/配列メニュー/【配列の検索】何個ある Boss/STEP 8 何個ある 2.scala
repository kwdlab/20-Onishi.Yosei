import scala.io.StdIn._

object Main extends App {

    val n = readLine().toInt
    val line = Array(1, 2, 5, 1, 4, 3, 2, 5, 1, 4)
    println(line.count(_ == n))
}
