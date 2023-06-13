import scala.io.StdIn._
import math.round
import math.pow

object Main extends App {

    val count = readLine().toInt

    for (i <- 0 until count){
        val line = readLine().split(" ")
        val numN = line(0).toDouble
        val numM = line(1).toInt

        val pre = (numN * pow(10,numM))
        val res = pre.round
        println(s"%.${numM}f".format(res/pow(10,numM).toDouble))
    }
}

//http://xerial.org/scala-cookbook/recipes/2012/07/05/string-format