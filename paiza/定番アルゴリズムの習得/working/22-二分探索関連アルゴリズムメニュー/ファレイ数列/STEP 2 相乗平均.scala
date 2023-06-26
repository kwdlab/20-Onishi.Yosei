import scala.io.StdIn._
import math.sqrt

object Main extends App {

    val Array(l, r) = readLine().trim().split(" ").map(_.toDouble)
    val mid = sqrt(l*r)
    println(mid)
}
