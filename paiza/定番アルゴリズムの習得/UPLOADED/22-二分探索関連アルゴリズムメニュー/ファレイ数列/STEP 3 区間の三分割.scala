import scala.io.StdIn._
import math.sqrt

object Main extends App {

    val Array(l, r) = readLine().trim().split(" ").map(_.toDouble)
    val midLeft = l + (r - l)/3
    val midRight = r - (r - l)/3
    println(s"$midLeft $midRight")
}
