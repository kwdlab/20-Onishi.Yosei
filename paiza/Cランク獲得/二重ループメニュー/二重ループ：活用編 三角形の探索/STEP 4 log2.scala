import scala.io.StdIn._
import math._

object Main extends App {

    val n = readLine().toInt

    def whileLoop(nx: Int, count: Int): Int = {
        if (pow(2, nx) > n){
            return count
        } else {
            val tmp = (n / pow(2, nx)).toInt
            whileLoop(nx+1, count+tmp)
        }
    }
    println(whileLoop(1, 0))
}