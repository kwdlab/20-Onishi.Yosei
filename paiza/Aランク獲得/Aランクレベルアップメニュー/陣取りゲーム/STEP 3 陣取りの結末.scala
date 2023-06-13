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
        (board(y)(x) != "#" && board(y)(x) != "*")
    }
    def nextToPlot(board: Array[Array[String]], yx: (Int, Int)): Array[Array[String]] = {
        val queue = Queue[(Int, Int)](yx)
        while (queue.nonEmpty) {
            val (y, x) = queue.dequeue()
            if (inMap(y-1, x)){
                if (noObject(board, y-1, x)){
                    board(y-1)(x) = "*"
                    queue.enqueue((y-1, x))
                }
            }
            if (inMap(y+1, x)){
                if (noObject(board, y+1, x)){
                    board(y+1)(x) = "*"
                    queue.enqueue((y+1, x))
                }
            }
            if (inMap(y, x-1)){
                if (noObject(board, y, x-1)){
                    board(y)(x-1) = "*"
                    queue.enqueue((y, x-1))
                }
            }
            if (inMap(y, x+1)){
                if (noObject(board, y, x+1)){
                    board(y)(x+1) = "*"
                    queue.enqueue((y, x+1))
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

/*
import scala.io.StdIn._

object Main extends App {
 
    val line = readLine().split(" ")
    val H = line(0).toInt
    val W = line(1).toInt
    val Sh = Array.ofDim[String](H, W)
    var playerQue: Array[(Int, Int)] = Array.empty

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
        (board(y)(x) != "#" && board(y)(x) != "*")
    }
    def nextToPlot(board: Array[Array[String]], yx: (Int, Int)): Array[Array[String]] = {
        val (y, x) = yx
        var count = 0
        if (inMap(y-1, x)){
            if (noObject(board, y-1, x)){
                board(y-1)(x) = "*"
                playerQue = playerQue ++ Array((y-1, x))
                count = count + 1
            }
        }
        if (inMap(y+1, x)){
            if (noObject(board, y+1, x)){
                board(y+1)(x) = "*"
                playerQue = playerQue ++ Array((y+1, x))
                count = count + 1
            }
        }
        if (inMap(y, x-1)){
            if (noObject(board, y, x-1)){
                board(y)(x-1) = "*"
                playerQue = playerQue ++ Array((y, x-1))
                count = count + 1
            }
        }
        if (inMap(y, x+1)){
            if (noObject(board, y, x+1)){
                board(y)(x+1) = "*"
                playerQue = playerQue ++ Array((y, x+1))
                count = count + 1
            }
        }

        if (count != 0){
            playerQue = playerQue.drop(1)
            val result = nextToPlot(board, playerQue(0))
            return result
        }
        return board
    }

    val YX = startSearch(Sh)
    playerQue = playerQue ++ Array(YX)
    val result = nextToPlot(Sh, playerQue(0))
    for (i <- result){
        println(i.mkString(""))
    }
}
*/