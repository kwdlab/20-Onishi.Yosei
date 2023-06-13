import scala.io.StdIn._
import math.abs

object Main extends App {

    val Array(n,a) = readLine().split(" ").map(_.toInt)
    def GCD(x: Int, y: Int): Int = {
        if (y == 0){ return x }
        else { return GCD(y, x%y) }
    }

    var none = true
    for (i <- 1 to 1000){
        val min = GCD(a, i)
        if (n%min != 0 && i != a){
            println(i)
            none = false
        }
    }
    if (none){
        println(-1)
    }
}

//解答例使用済み