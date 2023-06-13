import scala.io.StdIn._

object Main extends App {

    val Array(a, b) = readLine().trim().split(" ").map(_.toInt)
    val result = ((10000/a).round % b)

    println(result)  
}