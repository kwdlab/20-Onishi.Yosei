import scala.io.StdIn._
import scala.collection.mutable.Queue

object Main extends App {
 
    val Array(h, w, n) = readLine().split(" ").map(_.toInt)
    val Array(y, x) = readLine().split(" ").map(_.toInt)
    val Sh = Array.ofDim[String](h, w)
    val dataQueue = Queue[(Int, Int)]()

    for (i <- 0 until h; j <- 0 until w){
        Sh(i)(j) = "."
    }

    def inMap(y: Int, x: Int) : Boolean = {
        (0 <= y && y < h && 0 <= x && x < w)
    }
    def nextToPlot(board: Array[Array[String]], yx: (Int, Int)) = {
        val (y, x) = yx
        if (inMap(y-1, x)){
            board(y-1)(x) = "*"
            dataQueue.enqueue((y-1, x))
        }
        if (inMap(y+1, x)){
            board(y+1)(x) = "*"
            dataQueue.enqueue((y+1, x))
        }
        if (inMap(y, x+1)){
            board(y)(x+1) = "*"
            dataQueue.enqueue((y, x+1))
        }
        if (inMap(y, x-1)){
            board(y)(x-1) = "*"
            dataQueue.enqueue((y, x-1))
        }
    }
    def printOut(board: Array[Array[String]]) = {
        for (i <- board){
            println(i.mkString(""))
        }            
    }

    Sh(y)(x) = "*"    
    dataQueue.enqueue((y, x))
    for (_ <- 0 until n){
        val len = dataQueue.length
        for (i <- 0 until len){
            val data = dataQueue.dequeue()
            nextToPlot(Sh, data)
        }
    }
    printOut(Sh)
}
