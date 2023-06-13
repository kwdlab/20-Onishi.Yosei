import scala.io.StdIn._

object Main extends App {

    val n = readLine().trim().toInt
    val result = (1 to n).count(x => n%x == 0)

    println(result)
}