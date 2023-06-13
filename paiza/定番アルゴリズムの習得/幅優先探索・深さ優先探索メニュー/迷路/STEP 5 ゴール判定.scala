import scala.io.StdIn._
import scala.collection.mutable.Queue

object Main extends App {
 
    val Array(h, w) = readLine().split(" ").map(_.toInt)
    val Array(sy, sx) = readLine().split(" ").map(_.toInt)
    val Array(gy, gx) = readLine().split(" ").map(_.toInt)
    val Sh = Array.ofDim[String](h, w)
    val dataQueue = Queue[(Int, Int)]()

    for (i <- 0 until h){
        Sh(i) = readLine().split("")
    }

    def inMap(y: Int, x: Int) : Boolean = {
        (0 <= y && y < h && 0 <= x && x < w)
    }
    def noObject(y: Int, x: Int) : Boolean = {
        (Sh(y)(x) == ".")
    }
    def nextToPlot(board: Array[Array[String]], yx: (Int, Int)) = {
        val (y, x) = yx
        if (inMap(y-1, x) && noObject(y-1, x)){
            board(y-1)(x) = "*"
            dataQueue.enqueue((y-1, x))
        }
        if (inMap(y+1, x) && noObject(y+1, x)){
            board(y+1)(x) = "*"
            dataQueue.enqueue((y+1, x))
        }
        if (inMap(y, x+1) && noObject(y, x+1)){
            board(y)(x+1) = "*"
            dataQueue.enqueue((y, x+1))
        }
        if (inMap(y, x-1) && noObject(y, x-1)){
            board(y)(x-1) = "*"
            dataQueue.enqueue((y, x-1))
        }
    }
    def printOut(board: Array[Array[String]], yx: (Int, Int)) = {
        val (y, x) = yx
        if(board(y)(x) == "*"){
            println("Yes")
        }else{
            println("No")
        }
    }

    Sh(sy)(sx) = "*"    
    dataQueue.enqueue((sy, sx))
    while (dataQueue.nonEmpty){
        val len = dataQueue.length
        for (i <- 0 until len){
            val data = dataQueue.dequeue()
            nextToPlot(Sh, data)
        }
    }
    printOut(Sh, (gy, gx))
}
