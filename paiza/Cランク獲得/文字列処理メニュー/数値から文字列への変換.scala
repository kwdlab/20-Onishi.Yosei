import scala.io.StdIn._

object Main extends App {

    val X = readLine().toInt
    val Y = readLine().toInt
    val N = readLine().toInt

    val result = (X + Y).toString
    println(result(N-1))
}