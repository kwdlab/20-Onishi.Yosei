import scala.io.StdIn._

object Main extends App {

    val n = readLine().toInt
    val s = Array.fill(n)(readLine().split(" "))
    val name = readLine()

    println(s.filter(_(0) == name).map(_(1)).mkString(""))
}
