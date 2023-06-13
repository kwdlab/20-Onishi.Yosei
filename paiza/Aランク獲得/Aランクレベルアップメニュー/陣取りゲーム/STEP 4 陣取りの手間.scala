import scala.io.StdIn._
import scala.collection.mutable.Queue

object Main extends App {
 
    val line = readLine().split(" ")
    val H = line(0).toInt
    val W = line(1).toInt
    val Sh = Array.ofDim[String](H, W)

    for (i <- 0 until H){
        Sh(i) = readLine().split("")
    }

    def startSearch(board: Array[Array[String]]): (Int, Int) = {
        for (i <- 0 until H; j <- 0 until W){
            if (board(i)(j) == "*") {
                return (i, j)
            }
        }
        return (-1, -1)
    }
    def inMap(y: Int, x: Int) : Boolean = {
        (0 <= y && y < H && 0 <= x && x < W)
    }
    def noObject(board: Array[Array[String]], y: Int, x: Int) : Boolean = {
        (board(y)(x) == ".")
    }
    def nextToPlot(board: Array[Array[String]], yx: (Int, Int)): Array[Array[String]] = {
        val (y, x) = yx
        board(y)(x) = "0"
        var count = 0
        val queue = Queue[(Int, Int, Int)]((y, x, count))
        while (queue.nonEmpty) {
            val (y, x, count) = queue.dequeue()
            if (inMap(y-1, x)){
                if (noObject(board, y-1, x)){
                    board(y-1)(x) = s"${count+1}"
                    queue.enqueue((y-1, x, count+1))
                }
            }
            if (inMap(y+1, x)){
                if (noObject(board, y+1, x)){
                    board(y+1)(x) = s"${count+1}"
                    queue.enqueue((y+1, x, count+1))
                }
            }
            if (inMap(y, x-1)){
                if (noObject(board, y, x-1)){
                    board(y)(x-1) = s"${count+1}"
                    queue.enqueue((y, x-1, count+1))
                }
            }
            if (inMap(y, x+1)){
                if (noObject(board, y, x+1)){
                    board(y)(x+1) = s"${count+1}"
                    queue.enqueue((y, x+1, count+1))
                }
            }
        }
        return board
    }

    val result = nextToPlot(Sh, startSearch(Sh))
    for (i <- result){
        println(i.mkString(""))
    }
}