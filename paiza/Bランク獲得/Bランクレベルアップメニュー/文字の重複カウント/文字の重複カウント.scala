import scala.io.StdIn._

object Main extends App {

    val c = readLine()
    val s = readLine().split("")

    val result = s.count(x => x == c)
    println(result)
}
