import scala.io.StdIn._
import math.sqrt

object Main extends App {

    val Array(l, r) = readLine().trim().split(" ").map(_.toDouble)

    val phi = (1 + sqrt(5))/2
    val midLeft = l + (r - l)/(phi+1)
    val midRight = r - (r - l)/(phi+1)
    println(s"$midLeft $midRight")
}
