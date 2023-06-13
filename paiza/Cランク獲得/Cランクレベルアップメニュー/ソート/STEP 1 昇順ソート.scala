import scala.io.StdIn._

object Main extends App {

    val n = readLine().toInt
    val a = Array.fill(n)(readLine().trim().toInt)

    a.sorted.foreach(println)
}