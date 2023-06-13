import scala.io.StdIn._
import math._

object Main extends App {

    val N = readLine().toInt

    for (_ <- 0 until N){
        val i = readLine().toInt
        val flag = if (N == 1){ false } else { isPrime(i) }
        if (flag){
            println("pass")
        } else {
            println("failure")
        }
    }

    def isPrime(n: Int): Boolean = {
        if (n < 2) {return false}
        else if (n == 2 || n == 3) {return true}
        else if (n % 2 == 0 || n % 3 == 0) {return false}

        val sqrtN = sqrt(n).toInt
        var i = 5
        while (i <= sqrtN) {
            if (n % i == 0 || n % (i + 2) == 0) {return false}
            i = i + 6
        }
        return true
    }
}