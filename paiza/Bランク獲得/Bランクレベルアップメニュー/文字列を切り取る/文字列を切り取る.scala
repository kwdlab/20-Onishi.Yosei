import scala.io.StdIn._

object Main extends App {

    val ab = readLine().split(" ").map(_.toInt)
    val s = readLine()

    val result = s.drop(ab(0)-1).take(ab(1)-ab(0)+1)
    println(result)
}
