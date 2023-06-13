import scala.io.StdIn._

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
    def nextToPlot(board: Array[Array[String]], yx: (Int, Int)) = {
        val (y, x) = yx
        if (inMap(y-1, x)){
            board(y-1)(x) = "*"
        }
        if (inMap(y+1, x)){
            board(y+1)(x) = "*"
        }
        if (inMap(y, x+1)){
            board(y)(x+1) = "*"
        }
        if (inMap(y, x-1)){
            board(y)(x-1) = "*"
        }

        for (i <- board){
            println(i.mkString(""))
        }
    }

    nextToPlot(Sh, startSearch(Sh))
}
