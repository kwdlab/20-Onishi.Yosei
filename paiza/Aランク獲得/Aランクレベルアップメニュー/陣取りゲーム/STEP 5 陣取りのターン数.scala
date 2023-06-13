import scala.io.StdIn._
import scala.collection.mutable.Queue
import math.abs

object Main extends App {
 
    val line = readLine().split(" ")
    val H = line(0).toInt
    val W = line(1).toInt
    val N = line(2).toInt
    val Sh = Array.ofDim[String](H, W)
    val ln = Array.ofDim[Int](N)

    for (i <- 0 until H){
        Sh(i) = readLine().split("")
    }
    for (i <- 0 until N){
        ln(i) = readLine().toInt
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
        var count = 0
        val queue = Queue[(Int, Int, Int)]((y, x, count))

        def stringSelect(count: Int): String = {
            if (ln.contains(count)){ "?" } else { "*" }
        }

        board(y)(x) = stringSelect(0)
        while (queue.nonEmpty) {
            val (y, x, count) = queue.dequeue()
            def nextSub(Y: Int, X: Int) = {
                if (inMap(Y, X)){
                    if (noObject(board, Y, X)){
                        board(Y)(X) = stringSelect(count+1)
                        queue.enqueue((Y, X, count+1))
                    }
                }
            }
            nextSub(y-1, x)
            nextSub(y+1, x)
            nextSub(y, x-1)
            nextSub(y, x+1)
        }
        return board
    }

    val result = nextToPlot(Sh, startSearch(Sh))
    for (i <- result){
        println(i.mkString(""))
    }
}
