import scala.io.StdIn._

object Main extends App {

    val line = readLine().trim().split(" ").map(_.toInt)
    println(line.mkString(","))
}
