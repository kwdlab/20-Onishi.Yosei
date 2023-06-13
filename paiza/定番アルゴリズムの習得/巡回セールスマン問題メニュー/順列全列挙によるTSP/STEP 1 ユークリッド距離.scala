import scala.io.StdIn._
import math._

object Main extends App {

    def Euclidean(a: Array[Double], b: Array[Double]):Double = {
        val resEuc = sqrt(pow(a(0)-b(0), 2) + pow(a(1)-b(1), 2))
        return resEuc
    }

    val a = readLine().trim().split(" ").map(_.toDouble)
    val b = readLine().trim().split(" ").map(_.toDouble)
    println(Euclidean(a, b))
}