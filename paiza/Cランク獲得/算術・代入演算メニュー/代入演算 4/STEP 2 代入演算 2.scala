import scala.io.StdIn._

object Main extends App {

    val Array(a, b, c) = readLine().trim().split(" ").map(_.toInt)
    val result = ((0+a) * b) % c

    println(result)  
}
