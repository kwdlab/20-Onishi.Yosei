import scala.io.StdIn._
import math._

object Main extends App {

    val n = readLine().toInt
    val data = Array.ofDim[String](n, 2)
    for (i <- 0 until n){
        data(i) = readLine().split(" ")
    }
    val Array(k, l) = readLine().split(" ").map(_.toInt)

    def isPassed(data: Array[String], upper: Int, lower: Int): Unit = {
        if (upper >= data(1).toInt && data(1).toInt >= lower){
            println(data(0))
        }
    }

    for (i <- 0 until n){
        isPassed(data(i), l, k)
    }
}