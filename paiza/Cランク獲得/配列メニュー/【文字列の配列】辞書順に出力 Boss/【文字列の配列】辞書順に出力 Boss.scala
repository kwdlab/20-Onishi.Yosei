import scala.io.StdIn._

object Main extends App {

    val num = readLine().split(" ")
    val numK = num(1).toInt
    val line = readLine().split(" ").sorted

    println(line(numK-1))
}

