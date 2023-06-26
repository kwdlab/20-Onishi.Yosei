import scala.io.StdIn._
import math.abs

object Main extends App {

    def manhattahDist(x: Array[Int]): (Int, Int, Int) = {
        val res = abs(x(0)-0) + abs(x(1)-0).toInt
        return (res, x(0), x(1))
    }

    val n = readLine().toInt
    val tmp = Array.ofDim[(Int, Int, Int)](n)
    
    for (i <- 0 until n){
        tmp(i) = manhattahDist(readLine().split(" ").map(_.toInt))
    }
    
    val result = tmp.sortBy { case (x, _, _) => x }
    for ((_, x, y) <- result){
        println(s"${x} ${y}")
    }
}
