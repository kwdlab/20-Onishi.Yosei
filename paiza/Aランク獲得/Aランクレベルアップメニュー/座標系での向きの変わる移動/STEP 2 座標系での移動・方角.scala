import scala.io.StdIn._

object Main extends App {
    
    val Array(y, x, n) = readLine().trim().split(" ").map(_.toInt)

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
    def controlPin(cnt: Int, y: Int, x: Int): Unit = {
        if (cnt == n){
            return
        } else {
            val (resY, resX) = moving(readLine().trim(), y, x)
            println(s"${resY} ${resX}")
            controlPin(cnt+1, resY, resX)
        }
    }
    controlPin(0, y, x)
}
