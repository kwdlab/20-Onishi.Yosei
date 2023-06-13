import scala.io.StdIn._

object Main extends App {
    
    val line = readLine().split(" ")
    val y = line(0).toInt
    val x = line(1).toInt
    val d = line(2)
    val lr = readLine()

    def moving(dir: String, y: Int, x: Int) : (Int, Int) = {
        if (dir == "N"){
            return (y-1, x)
        } else if (dir == "S"){
            return (y+1, x)
        } else if (dir == "E"){
            return (y, x+1)
        } else {
            return (y, x-1)
        } 
    }
    def turning(dir: String, rl: String, y: Int, x: Int):(Int, Int) = {
        val newdir = if (rl == "R"){
            if(dir == "N"){
                "E"
            } else if(dir == "S"){
                "W"
            } else if(dir == "E"){
                "S"
            } else {
                "N"
            }
        } else {
            if(dir == "N"){
                "W"
            } else if(dir == "S"){
                "E"
            } else if(dir == "E"){
                "N"
            } else {
                "S"
            }
        }
        return moving(newdir, y, x)
    }

    val (resY, resX) = turning(d, lr, y, x)
    println(s"${resY} ${resX}")
}
