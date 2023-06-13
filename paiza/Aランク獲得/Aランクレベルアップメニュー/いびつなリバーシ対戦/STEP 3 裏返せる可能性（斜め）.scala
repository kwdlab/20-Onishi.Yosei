import scala.io.StdIn._
import math.abs

object Main extends App {
    val Array(h, w, y, x) = readLine().split(" ").map(_.toInt)

    def nextToPlot(h: Int, w: Int, y: Int, x: Int): Array[Array[String]] = {
        val board =  Array.ofDim[String](h, w)
        
        for (i <- 0 until h; j <- 0 until w){
            if (i == y && j == x){
                board(i)(j) = "!" 
            } else {
                innerFunc(i, j)
            }
        }
        def innerFunc(i: Int, j: Int) = {
            val Y = abs(y - i)
            val X = abs(x - j)

            if (Y == X){
                board(i)(j) = "*"
            } else {
                board(i)(j) = "."
            }
        }
        return board
    }

    val result = nextToPlot(h, w, y, x)
    for (i <- result){
        println(i.mkString(""))
    }
}
