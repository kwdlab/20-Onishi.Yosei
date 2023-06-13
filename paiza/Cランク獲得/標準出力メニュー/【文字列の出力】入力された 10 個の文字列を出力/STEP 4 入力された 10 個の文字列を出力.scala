import scala.io.StdIn._

object Main extends App {

    val result = Array.fill(10)(readLine())
    println(result.mkString(" "))
}