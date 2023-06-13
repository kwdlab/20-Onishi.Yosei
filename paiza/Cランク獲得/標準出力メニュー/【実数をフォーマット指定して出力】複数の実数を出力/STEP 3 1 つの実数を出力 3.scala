import scala.io.StdIn._
import math.round

object Main extends App {

    val num = readLine().toFloat
    val pre = (num * 1000)
    val res = pre.round
    println("%.3f".format(res/1000.toDouble))
}

//http://xerial.org/scala-cookbook/recipes/2012/07/05/string-format