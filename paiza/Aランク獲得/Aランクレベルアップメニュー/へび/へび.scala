import scala.io.StdIn._

object Main extends App {
 
    val Array(h, w, sy, sx, n) = readLine().trim().split(" ").map(_.toInt)
    val Sh = Array.fill(h)(readLine().trim().split(""))
    val tdN: Map[Int, String] = (0 until n).foldLeft(Map.empty[Int, String]) { (map, _) =>
        val Array(t, d) = readLine().split(" ")
        map + (t.toInt -> d)
    }

    def noObject(y: Int, x: Int) : Boolean = {
        return (Sh(y)(x) == ".")
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
            case "N" => dir
        }
        nextPlot(nowdir, y, x)
    }

    def mainFuncion(cnt: Int, m: String, y: Int, x: Int): Unit = {
        if (cnt == 100){
            Sh(y)(x) = "*"
            return
        } else {
            val d = tdN.getOrElse(cnt, "N")
            val (newY, newX, dir) = headDir(m, d, y, x)
            if (!(inMap(newY, newX))){
                Sh(y)(x) = "*"
            } else {
                Sh(y)(x) = "*"
                mainFuncion(cnt+1, dir, newY, newX)
            }
        }
    }
    mainFuncion(0, "N", sy, sx)
    for (i <- Sh){
        println(i.mkString(""))
    }
}