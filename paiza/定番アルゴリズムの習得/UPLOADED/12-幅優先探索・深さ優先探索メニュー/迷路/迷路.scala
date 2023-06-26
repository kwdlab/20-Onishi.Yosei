import scala.io.StdIn._
import scala.collection.mutable.Queue

object Main extends App {

    val Array(h, w) = readLine().split(" ").map(_.toInt)
    val Array(sy, sx) = readLine().split(" ").map(_.toInt)
    val Array(gy, gx) = readLine().split(" ").map(_.toInt)
    val s = Array.fill(h)(readLine().split(""))
    val dataQueue = Queue[(Int, Int)]()

    def nextToPlot(board: Array[Array[String]], y: Int, x: Int) = {
        def inMap(y: Int, x: Int): Boolean = {
            (0 <= y && y < h && 0 <= x && x < w)
        }
        def never(y: Int, x: Int): Boolean = {
            (board(y)(x) != "*")
        }
        def wall(y: Int, x: Int): Boolean = {
            (board(y)(x) != "#")
        }
        def plotCell(y: Int, x: Int): Unit = {
            if (inMap(y, x) && never(y, x) && wall(y, x)){
                board(y)(x) = "*"
                dataQueue.enqueue((y, x))
            }
        }
        
        plotCell(y - 1, x)
        plotCell(y + 1, x)
        plotCell(y, x + 1)
        plotCell(y, x - 1)
    }

    def controler():Unit = {
        s(sy)(sx) = "*"    
        dataQueue.enqueue((sy, sx))
        var count = 0
        while (dataQueue.nonEmpty){
            count = count + 1
            val len = dataQueue.length
            for (_ <- 0 until len){
                val (y, x) = dataQueue.dequeue()
                nextToPlot(s, y, x)
            }
            if (s(gy)(gx) == "*"){
                println(count)
                return
            }
        }
        println("No")
    }
    controler()
}
