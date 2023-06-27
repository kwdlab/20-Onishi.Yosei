import scala.io.StdIn._

object Main extends App {
 
    val Array(h, w) = readLine().split(" ").map(_.toInt)
    val Array(y, x) = readLine().split(" ").map(_.toInt)
    val Sh = Array.fill(h, w)(".")

    def nextToPlot(board: Array[Array[String]], y: Int, x: Int) = {
        board(y)(x) = "*"
 
        def inMap(y: Int, x: Int): Boolean = {
            (0 <= y && y < h && 0 <= x && x < w)
        }
        if (inMap(y-1, x)) board(y-1)(x) = "*"
        if (inMap(y+1, x)) board(y+1)(x) = "*"
        if (inMap(y, x+1)) board(y)(x+1) = "*"
        if (inMap(y, x-1)) board(y)(x-1) = "*"

        board.foreach(i => println(i.mkString("")))
    }

    nextToPlot(Sh, y, x)
}