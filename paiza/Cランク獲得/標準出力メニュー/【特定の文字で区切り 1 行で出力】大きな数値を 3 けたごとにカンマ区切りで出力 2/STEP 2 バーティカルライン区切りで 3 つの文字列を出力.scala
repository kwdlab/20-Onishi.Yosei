import scala.io.StdIn._

object Main extends App {

    val line = Array.fill(3)(readLine().trim())

    println(line.mkString("|"))
}
