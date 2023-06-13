import scala.io.StdIn._

object Main extends App {

    val line = readLine().split(" ").map(_.toInt)

    println(line.sum)
}
