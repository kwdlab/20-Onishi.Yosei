import scala.io.StdIn._

object Main extends App {

    val line = Array.fill(10)(readLine().trim().toInt)

    println(line.mkString(" | "))
}
