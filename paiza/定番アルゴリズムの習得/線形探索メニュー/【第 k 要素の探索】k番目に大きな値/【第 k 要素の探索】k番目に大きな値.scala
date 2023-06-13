import scala.io.StdIn._
import math._

object Main extends App {

    val n = readLine().toInt
    val An = readLine().split(" ").map(_.toLong)
    val k = readLine().toInt

    println(An.sorted.reverse.take(k)(k-1))
}