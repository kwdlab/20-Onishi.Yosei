import scala.io.StdIn._

object Main extends App {

    val n = readLine().trim().toInt
    val a = readLine().split(" ").map(_.toInt)
    println(a.count(_ % 3 == 0))
}
