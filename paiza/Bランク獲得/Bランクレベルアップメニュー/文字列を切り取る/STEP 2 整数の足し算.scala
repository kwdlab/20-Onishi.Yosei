import scala.io.StdIn._

object Main extends App {

    val ab = readLine().split(" ").map(_.toInt)

    println(ab.sum)
}
