import scala.io.StdIn._

object Main extends App {

    val n = readLine().toInt
    val a = Array.fill(n)(readLine().split(" ").map(_.toInt).drop(1).sum)

    a.foreach(println)
}