import scala.io.StdIn._
import math._

object Main extends App {

    def Euclidean(a: Array[Double], b: Array[Double]): Double = {
        val resEuc = sqrt(pow(a(0) - b(0), 2) + pow(a(1) - b(1), 2))
        resEuc
    }

    def dynamicProgramming(n: Int, points: Array[Array[Double]], s: Int):Unit = {
        val d = Array.ofDim[Double](n, math.pow(2, n).toInt)
        val before = Array.ofDim[Int](n, math.pow(2, n).toInt)

        for (i <- 0 until n; b <- 0 until math.pow(2, n).toInt) {
            d(i)(b) = Double.PositiveInfinity
        }

        for (i <- 0 until n) {
            d(i)(math.pow(2, i).toInt) = Euclidean(points(s), points(i))
            before(i)(math.pow(2, i).toInt) = s
        }

        for (b <- 0 until math.pow(2, n).toInt; i <- 0 until n) {
            if ((b >> i & 1) == 0) {
            }
            for (j <- 0 until n) {
                if ((b >> j & 1) == 1) {

                } else {
                    val tmp = d(i)(b) + Euclidean(points(i), points(j))
                    if (tmp < d(j)(b | (1 << j))) {
                        d(j)(b | (1 << j)) = tmp
                        before(j)(b | (1 << j)) = i
                    }                    
                }
            }
        }

        val tour = Array.ofDim[Int](n)
        var pos = s
        var bb = (1 << n) - 1
        for (i <- 0 until n) {
            tour(i) = before(pos)(bb)
            bb = bb ^ (1 << pos)
            pos = tour(i)
        }

        println(d(s)((1 << n) - 1))
        println(tour.mkString(" "))
    }

    val n = readLine().trim().toInt
    val points = Array.ofDim[Double](n, 2)
    for (i <- 0 until n) {
        points(i) = readLine().trim().split(" ").map(_.toDouble)
    }

    dynamicProgramming(n, points, 0)
}
//解答例使用済み