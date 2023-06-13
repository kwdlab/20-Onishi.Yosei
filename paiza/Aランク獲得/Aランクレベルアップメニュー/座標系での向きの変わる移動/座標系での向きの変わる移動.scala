import scala.io.StdIn._

object Main extends App {
    
    val YXN = readLine().split(" ").map(_.toInt)
    var X = YXN(0)
    var Y = YXN(1)
    val N = YXN(2)
    var nowdir = "N"

    for (i <- 0 until N){
        val Dn = readLine()
        turning(nowdir, Dn, Y, X)
        println(s"${X} ${Y}")
    }

    def moving(dir: String, y: Int, x: Int) : Unit = {
        dir match {
            case "N" => Y = y - 1
            case "S" => Y = y + 1
            case "E" => X = x + 1
            case "W" => X = x - 1
        }
    }
    def turning(dir: String, rl: String, y: Int, x: Int) : Unit = {
        if (rl == "R"){
            if(dir == "N"){
                nowdir = "E"
            } else if(dir == "S"){
                nowdir = "W"
            } else if(dir == "E"){
                nowdir = "S"
            } else if(dir == "W"){
                nowdir = "N"
            }
        }
        if (rl == "L"){
            if(dir == "N"){
                nowdir = "W"
            } else if(dir == "S"){
                nowdir = "E"
            } else if(dir == "E"){
                nowdir = "N"
            } else if(dir == "W"){
                nowdir = "S"
            }
        }
        moving(nowdir, y, x)
    }
}
