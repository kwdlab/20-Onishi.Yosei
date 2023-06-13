import scala.io.StdIn._

object Main extends App {
 
    val Array(h, w) = readLine().split(" ").map(_.toInt)
    val Array(y, x) = readLine().split(" ").map(_.toInt)
    val Sh = Array.ofDim[String](h, w)

    def inMap(y: Int, x: Int) : Boolean = {
        (0 <= y && y < h && 0 <= x && x < w)
    }
    def nextToPlot(board: Array[Array[String]], yx: (Int, Int)) = {
        val (y, x) = yx
        board(y)(x) = "*"
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

        for (i <- 0 until h; j <- 0 until w){
            if(board(i)(j) != "*"){
                board(i)(j) = "."
            } 
        }

        for (i <- board){
            println(i.mkString(""))
        }
    }

    nextToPlot(Sh, (y, x))
}
