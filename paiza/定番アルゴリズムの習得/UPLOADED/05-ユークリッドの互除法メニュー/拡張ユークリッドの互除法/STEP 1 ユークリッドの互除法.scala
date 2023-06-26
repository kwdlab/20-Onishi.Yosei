import scala.io.StdIn._

object Main extends App {

    val line = readLine().split(" ").map(_.toLong)
    val a = line(0)
    val b = line(1)
    
    def GCD(x: Long, y: Long): Long = {
        if (y == 0){ return x }
        else { return GCD(y, x%y) }
    }
    println(GCD(a, b))
}