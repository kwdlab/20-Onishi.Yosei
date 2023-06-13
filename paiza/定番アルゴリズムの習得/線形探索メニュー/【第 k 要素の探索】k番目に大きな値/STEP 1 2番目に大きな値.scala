import scala.io.StdIn._
import math._

object Main extends App {

    val n = readLine().toInt
    val An = readLine().split(" ").map(_.toLong)

    println(An.sorted.reverse.take(2)(1))
}