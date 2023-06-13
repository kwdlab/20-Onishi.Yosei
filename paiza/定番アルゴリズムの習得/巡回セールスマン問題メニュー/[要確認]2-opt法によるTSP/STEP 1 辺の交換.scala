import scala.io.StdIn._
import scala.math._

object Main extends App {

    def Euclidean(a: Array[Double], b: Array[Double]):Double = {
        return sqrt(pow(a(0)-b(0), 2) + pow(a(1)-b(1), 2))
    }

    val n = readLine().trim().toInt
    val points = Array.ofDim[Double](n, 2)
    for (i <- 0 until n) {
        points(i) = readLine().trim().split(" ").map(_.toDouble)
    }

    val tour = Array.ofDim[Int](n)
    for (i <- 0 until n) {
        tour(i) = readLine().trim().toInt
    }

    val Array(a, b) = readLine().trim().split(" ").map(_.toInt)

    val d_before = Euclidean(points(tour(a)), points(tour((a + 1) % n))) + Euclidean(points(tour(b)), points(tour((b + 1) % n)))
    val d_after = Euclidean(points(tour(a)), points(tour(b))) + Euclidean(points(tour((a + 1) % n)), points(tour((b + 1) % n)))

    if (d_after < d_before) {
        println("Yes")
        val reversedSlice = tour.slice(a + 1, b + 1).reverse
        val tmp = tour.take(a + 1) ++ reversedSlice ++ tour.drop(b+1)
        for (i <- 0 until n) {
            println(tmp(i))
        }
    } else {
        println("No")
    }
}
// 解答例使用済み