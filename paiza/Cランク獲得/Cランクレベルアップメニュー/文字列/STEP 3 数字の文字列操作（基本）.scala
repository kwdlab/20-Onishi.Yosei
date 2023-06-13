import scala.io.StdIn._

object Main extends App {

    val S = readLine().split("").map(_.toInt)

    val a = S(0) + S(3)
    val b = S(1) + S(2)

    println(s"${a}${b}")
}