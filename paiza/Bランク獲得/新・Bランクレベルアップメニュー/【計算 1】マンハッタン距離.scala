import scala.io.StdIn._
import math._

object Main extends App {

    val Array(px, py) = readLine().split(" ").map(_.toInt)
    val n = readLine().toInt
    val data = Array.fill(n)(readLine().split(" ").map(_.toInt))

    val ManData: Array[Array[Int]] = (0 until n).foldLeft(Array.empty[Array[Int]]) { (array, i) =>
        array :+ Array(manhattan(data(i)), i+1)
    }
    val EucData: Array[Array[Int]] = (0 until n).foldLeft(Array.empty[Array[Int]]) { (array, i) =>
        array :+ Array(euclidean(data(i)), i+1)
    }

    def manhattan(x: Array[Int]): Int = {
        return abs(x(0)-px) + abs(x(1)-py).toInt
    }
    def euclidean(x: Array[Int]): Int = {
        return sqrt(pow(x(0)-px , 2) + pow(x(1)-py , 2)).toInt
    }
    def printOut(data: Array[Array[Int]]): Unit = {
        def withSort(): Array[Array[Int]] = {
            val tmp = data.sortWith {
                case (Array(value1, num1), Array(value2, num2)) => {
                    if (value1 != value2) {
                        value1 < value2
                    } else {
                        num1 < num2
                    }
                } 
            }
            return tmp
        }
        val sortData = withSort().take(3).map(_(1))
        sortData.foreach(println)
    }

    printOut(EucData)
    printOut(ManData)
}