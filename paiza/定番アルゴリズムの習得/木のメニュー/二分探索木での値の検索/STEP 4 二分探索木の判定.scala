import scala.io.StdIn._

object Main extends App {
    val Array(n, r) = readLine().trim().split(" ").map(_.toInt)

    def printOut():Boolean = {
        for (_ <- 1 until n){
            val line = readLine().trim().split(" ")
            val a = line(0).toInt
            val b = line(1).toInt
            val lr = line(2)
            lr match {
                case "L" => {
                    if (!(b < a)) {
                        println("NO")
                        return false
                    }
                }
                case "R" =>{
                    if (!(a < b)) {
                        println("NO")
                        return false
                    }
                }
            }
        }
        return true
    }  
    if (printOut){
        println("YES")
    }
}