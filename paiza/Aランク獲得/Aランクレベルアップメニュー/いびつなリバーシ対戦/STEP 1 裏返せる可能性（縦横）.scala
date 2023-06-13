import scala.io.StdIn._

object Main extends App {
 
    val line = readLine().split(" ")
    val H = line(0).toInt
    val W = line(1).toInt
    val Y = line(2).toInt
    val X = line(3).toInt
    val Sh = Array.ofDim[String](H, W)

    def nextToPlot(board: Array[Array[String]], yx: (Int, Int)): Array[Array[String]] = {
        val (y, x) = yx

        for (i <- 0 until H; j <- 0 until W){
            if (i == y && j == x){
                board(i)(j) = "!" 
            }
            else if (i == y || j == x){
                board(i)(j) = "*" 
            }
            else {
                board(i)(j) = "."
            }
        }
        return board
    }

    val result = nextToPlot(Sh, (Y, X))
    for (i <- result){
        println(i.mkString(""))
    }
}
