import scala.io.StdIn._

object Main extends App {

    val num = readLine.toInt
    val line = "1 3 5 4 6 2 1 7 1 5".split(" ")

    println(line(num-1))
}