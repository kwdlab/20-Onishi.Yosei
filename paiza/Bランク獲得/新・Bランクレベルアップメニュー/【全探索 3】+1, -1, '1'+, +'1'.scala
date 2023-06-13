import scala.io.StdIn._
import math._

object Main extends App {

    val n = readLine().toInt
    val x = Array.fill(n)(readLine().toInt)
    val pair = x.combinations(2).toList

    def operation(x: Int, y: Int) : Int = {

        def plus(num: Int) : Int = {
            return num + 1
        }
        def minus(num: Int) : Int = {
            return num - 1
        }
        def head(num: Int) : Int = {
            return pow(10, num.toString.length).toInt + num
        }
        def tail(num: Int) : Int = {
            return 10*num + 1
        }
        def none(num: Int) : Int = {
            return num
        }

        val rx = Array(plus(x), minus(x), head(x), tail(x), none(x))
        val ry = Array(plus(y), minus(y), head(y), tail(y), none(y))

        val XY = for {
            i <- rx
            j <- ry
        } yield abs(i - j)
        
        return XY.min
    }

    val all: Array[Int] = (0 until pair.length).foldLeft(Array.empty[Int]) { (array, j) =>
        array :+ operation(pair(j)(0), pair(j)(1))
    }
    println(all.min)
}