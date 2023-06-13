import scala.io.StdIn._

object Main extends App {
 
    val line = readLine().split(" ")
    val H = line(0).toInt
    val W = line(1).toInt
    val sy = line(2).toInt
    val sx = line(3).toInt
    val m = line(4)
    val Sh = Array.ofDim[String](H, W)

    for (i <- 0 until H){
        Sh(i) = readLine().split("")
    }

    def noObject(y: Int, x: Int) : Boolean = {
        return (Sh(y)(x) != "#")
    }
    def inMap(y: Int, x: Int) : Boolean = {
        if (0 <= y && y < H && 0 <= x && x < W){
            return noObject(y, x)
        } else {
            return false
        }
    }
    def nextPlot(m: String, y: Int, x: Int) : (Int, Int) = {
        val (a, b) = m match{
            case "N" => (y-1, x)
            case "S" => (y+1, x)
            case "W" => (y, x-1)
            case "E" => (y, x+1)
        }
        return (a, b)
    }
    
    val (newY, newX) = nextPlot(m, sy, sx)
    if (inMap(newY, newX)) { println("Yes") } 
    else { println("No")}
}
