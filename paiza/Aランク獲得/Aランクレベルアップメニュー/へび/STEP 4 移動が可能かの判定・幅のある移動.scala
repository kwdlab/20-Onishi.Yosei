import scala.io.StdIn._

object Main extends App {
 
    val Array(h, w, sy, sx, n) = readLine().trim().split(" ").map(_.toInt)
    val Sh = Array.fill(h)(readLine().trim().split(""))

    def noObject(y: Int, x: Int) : Boolean = {
        return (Sh(y)(x) != "#")
    }
    def inMap(y: Int, x: Int) : Boolean = {
        if (0 <= y && y < h && 0 <= x && x < w){
            return noObject(y, x)
        } else {
            return false
        }
    }
    def nextPlot(m: String, y: Int, x: Int) : (Int, Int, String) = {
        val (a, b, dir) = m match{
            case "N" => (y-1, x, "N")
            case "S" => (y+1, x, "S")
            case "W" => (y, x-1, "W")
            case "E" => (y, x+1, "E")
        }
        return (a, b, dir)
    }
    def headDir(dir: String, rl: String, y: Int, x: Int) : (Int, Int, String) = {
        val nowdir = rl match{
            case "R" => dir match{
                case "N" => "E"
                case "S" => "W"
                case "W" => "N"
                case "E" => "S"
            }
            case "L" => dir match{
                case "N" => "W"
                case "S" => "E"
                case "W" => "S"
                case "E" => "N"
            }
        }
        nextPlot(nowdir, y, x)
    }

    def mainFuncion(cnt: Int, m: String, y: Int, x: Int): Unit = {
        if (cnt == n){
            return
        } else {
            val Array(d, step) = readLine().trim().split(" ")

            def innerStep(i: Int, y: Int, x: Int, dir: String): (Int, Int, String) = {
                if (i == step.toInt){
                    return (y, x, dir)
                } else {
                    val (newY, newX, newDir) = headDir(m, d, y, x)
                    if (!(inMap(newY, newX))){
                        println(s"${y} ${x}")
                        println("Stop")
                        return (-1, -1, "")
                    } else {
                        innerStep(i+1, newY, newX, newDir)
                    }                       
                }
            }
            val (newY, newX, newDir) = innerStep(0, y, x, "")

            if (newY == -1 && newX == -1 && newDir == ""){
                return
            } else {
                println(s"${newY} ${newX}")
                mainFuncion(cnt+1, newDir, newY, newX)
            }      
        }
    }
    mainFuncion(0, "N", sy, sx)
}