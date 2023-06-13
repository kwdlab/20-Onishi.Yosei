import scala.io.StdIn._
import math.abs

object Main extends App {

    val line = readLine().split(" ")
    val A = line(0).toInt
    val B = line(1).toInt
    val cal = line(2)
    val C = line(3).toInt
    val D = line(4).toInt

   
    val (nega, n, d) = cal match {
        case "+" => addition(A, B, C, D)
        case "-" => subtraction(A, B, C, D)
        case "*" => multiplication(A, B, C, D)
        case "/" => division(A, B, C, D)
    }

    def GCD(x: Int, y: Int): Int = {
        if (y == 0){ return x }
        else { return GCD(y, x%y) }
    }
    def addition(a: Int, b: Int, c: Int, d: Int): (Boolean, Int, Int) = {
        val top = a*d + b*c
        val bottom = b*d

        val ret1 = negative(top, bottom)
        val (ret2, ret3) = reduction(abs(top), abs(bottom))
        return (ret1, ret2, ret3)
    }
    def subtraction(a: Int, b: Int, c: Int, d: Int): (Boolean, Int, Int) = {
        val top = a*d - b*c
        val bottom = b*d

        val ret1 = negative(top, bottom)
        val (ret2, ret3) = reduction(abs(top), abs(bottom))
        return (ret1, ret2, ret3)
    }
    def multiplication(a: Int, b: Int, c: Int, d: Int): (Boolean, Int, Int) = {
        val top = a*c
        val bottom = b*d

        val ret1 = negative(top, bottom)
        val (ret2, ret3) = reduction(abs(top), abs(bottom))
        return (ret1, ret2, ret3)
    }
    def division(a: Int, b: Int, c: Int, d: Int): (Boolean, Int, Int) = {
        val top = a*d
        val bottom = b*c

        val ret1 = negative(top, bottom)
        val (ret2, ret3) = reduction(abs(top), abs(bottom))
        return (ret1, ret2, ret3)
    }
    def reduction(t: Int, b: Int): (Int, Int) = {
        val num = GCD(t, b)
        return (t/num, b/num)
    }
    def negative(t: Int, b: Int): Boolean = {
        if (t < 0 && b < 0){
            return false
        } else if (t < 0 || b < 0){
            return true
        } else {
            return false
        }
    }

    if (nega){
        println(s"${-1 * n} ${d}")
    } else {
        println(s"${n} ${d}")
    }

}
