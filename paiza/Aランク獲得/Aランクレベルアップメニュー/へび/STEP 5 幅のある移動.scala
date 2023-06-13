import scala.io.StdIn._
import scala.collection.mutable.ArrayDeque

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
    def mainFuncion(cnt: Int, m: String, y: Int, x: Int, result: ArrayDeque[(Int, Int)]): ArrayDeque[(Int, Int)] = {
        if (cnt == n){
            return result
        } else {
            val Array(d, step) = readLine().trim().split(" ")
            result.append((y, x))

            def innerStep(i: Int, y: Int, x: Int, dir: String): (Int, Int, String, Boolean) = {
                if (i == step.toInt){
                    return (y, x, dir, false)
                } else {
                    val (newY, newX, newDir) = headDir(m, d, y, x)
                    if (!(inMap(newY, newX))){
                        result.append((y, x))
                        return (y, x, dir, true)
                    } else {
                        innerStep(i+1, newY, newX, newDir)
                    }                       
                }
            }
            val (newY, newX, newDir, flag) = innerStep(0, y, x, "")

            if (flag){
                return result
            } else {
                result.append((newY, newX))
                mainFuncion(cnt+1, newDir, newY, newX, result)
            }      
        }
    }
    def printout(result: ArrayDeque[(Int, Int)]) = {
        for (tmp <- result.sliding(2).toList){
            val (fromY, fromX) = tmp(0)
            val (toY, toX) = tmp(1)

            val xlist = (Array(fromX, toX).min to Array(fromX, toX).max)
            val ylist = (Array(fromY, toY).min to Array(fromY, toY).max)
            for ((i, j) <- ylist.zipAll(xlist, fromY, fromX)){
                Sh(i)(j) = "*"
            }
        }
        for (i <- Sh){
            println(i.mkString(""))
        }
    }

    val tmp = ArrayDeque[(Int, Int)]()
    printout(mainFuncion(0, "N", sy, sx, tmp))
}