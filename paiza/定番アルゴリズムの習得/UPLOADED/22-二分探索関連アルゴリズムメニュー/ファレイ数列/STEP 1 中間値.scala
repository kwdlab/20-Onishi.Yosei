import scala.io.StdIn._

object Main extends App {

    val Array(l, r) = readLine().trim().split(" ").map(_.toDouble)
    val mid = (l+r) / 2
    println(mid)
}
