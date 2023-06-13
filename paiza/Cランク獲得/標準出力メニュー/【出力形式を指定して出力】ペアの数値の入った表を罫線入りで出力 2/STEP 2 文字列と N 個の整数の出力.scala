import scala.io.StdIn._

object Main extends App {
    
    val Array(n, a, b) = readLine().trim().split(" ").map(_.toInt)
    val result = Array.fill(n)(s"(${a}, ${b})")

    println(result.mkString(", "))
}
