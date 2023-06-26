import scala.io.StdIn._

object Main extends App {

    val Array(a, b, c, d) = readLine().trim().split(" ").map(_.toInt)

    println(s"${a+c}/${b+d}")
}
