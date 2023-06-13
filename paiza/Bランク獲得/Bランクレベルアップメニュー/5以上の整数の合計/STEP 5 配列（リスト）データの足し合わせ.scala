import scala.io.StdIn._

object Main extends App {

    val n = Array(4, 0, 5, -1, 3, 10, 6, -8)

    println(n.filter(x => x >= 5).sum)
}
