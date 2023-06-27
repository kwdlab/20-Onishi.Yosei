import scala.io.StdIn.readLine
import scala.math._

object Main extends App {

    def Euclidean(a: Array[Double], b: Array[Double]):Double = {
        val resEuc = sqrt(pow(a(0)-b(0), 2) + pow(a(1)-b(1), 2))
        return resEuc
    }

    def dynamicProgramming(n: Int, points: Array[Array[Double]], s: Int): Double = {
        val d = Array.ofDim[Double](n, 1 << n)

        for (i <- 0 until n; b <- 0 until (1 << n)) {
            d(i)(b) = Double.PositiveInfinity
        }

        for (i <- 0 until n) {
            d(i)(1 << i) = Euclidean(points(s), points(i))
        }

        for (b <- 0 until (1 << n); i <- 0 until n) {
            if ((b >> i & 1) == 0) {
                
            } else {
                for (j <- 0 until n) {
                    if ((b >> j & 1) == 1) {

                    } else {
                        val tmp = d(i)(b) + Euclidean(points(i), points(j))
                        if (tmp < d(j)(b | (1 << j))) {
                            d(j)(b | (1 << j)) = tmp
                        }
                    }
                }
            }
        }
        d(0)((1 << n) - 1)
    }

    val n = readLine().trim().toInt
    val points = Array.ofDim[Double](n, 2)
    for (i <- 0 until n) {
        points(i) = readLine().trim().split(" ").map(_.toDouble)
    }

    val ans = dynamicProgramming(n, points, 0)
    println(ans)
}
//解答例使用済み