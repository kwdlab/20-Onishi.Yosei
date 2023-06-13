import scala.io.StdIn._
import math._

object Main extends App {

    val n = readLine().toInt
    val data = Array.ofDim[Int](n, 2)
    for (i <- 0 until n){
        data(i) = readLine().split(" ").map(_.toInt)
    }
    val Array(xs, xt) = readLine().split(" ").map(_.toInt)
    val Array(ys, yt) = readLine().split(" ").map(_.toInt)

    def inSquare(dot: Array[Int], xs: Int, xt: Int, ys: Int, yt: Int): Boolean = {
        val X = dot(0)
        val Y = dot(1)
        return (xs <= X && X <= xt && ys <= Y && Y <= yt)
    }

    val count = (0 until n).foldLeft(0) { (count, i) =>
        if (inSquare(data(i), xs, xt, ys, yt)) count + 1 else count
    }
    println(count)
}