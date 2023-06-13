import scala.io.StdIn._

object Main extends App {

    val n = readLine().toInt
    val line = readLine.split(" ").map(_.toInt)

    line.map(_ * 2).foreach(println)
}
