import scala.io.StdIn._
import math._

object Main extends App {

    val n = readLine().toInt
    val data = Array.ofDim[Int](n, 2)
    for (i <- 0 until n){
        data(i) = readLine().split(" ").map(_.toInt)
    }
    val k = readLine().toInt

    def Manhattan(x: Array[Int], tar: Array[Int], k: Int): Boolean = {
        val result = abs(x(0)-tar(0)) + abs(x(1)-tar(1)).toInt
        return (result <= k)
    }

    val count = (0 to n-1).foldLeft(0) { (count, i) =>
        if (Manhattan(data(i), data(n-1), k)) count + 1 else count
    }
    println(count)
}