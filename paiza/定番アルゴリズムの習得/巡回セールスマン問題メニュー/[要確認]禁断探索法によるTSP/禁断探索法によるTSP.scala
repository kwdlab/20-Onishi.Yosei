import scala.io.StdIn._
import scala.math._
import scala.collection.mutable.ArrayDeque

object Main extends App {

    def euclidean(a: Array[Double], b: Array[Double]):Double = {
        return sqrt(pow(a(0)-b(0), 2) + pow(a(1)-b(1), 2))
    }
    def calcLength(tour: Array[Int], n: Int, points: Array[Array[Double]], cnt: Int, length: Double): Double = {
        if (cnt == n){
            return length
        } else {
            calcLength(tour, n, points, cnt+1, length + euclidean(points(tour(cnt)), points(tour((cnt + 1) % n))))
        }
    }
    def tabuSearch(tour: Array[Int], q: Int, tl: Int, n: Int, points: Array[Array[Double]], cnt: Int): Array[Int] = {
        val tourBest = tour.clone()
        var length = calcLength(tourBest, n, points, 0, 0.0)
        val tabuList = ArrayDeque[Int]()

        for (i <- 0 until q) {
            def bestABsearch(a: Int, b: Int, bestA: Int, bestB: Int, diff: Double):(Int, Int) = {
                if (a >= n){
                    return (bestA, bestB)
                } else if (tabuList.contains(tour(a))){
                    bestABsearch(a+1, a+1+2, bestA, bestB, diff)
                } else if (b >= n){
                    bestABsearch(a+1, a+1+2, bestA, bestB, diff)
                } else if (a == 0 && b == n - 1){
                    bestABsearch(a, b+1, bestA, bestB, diff)
                } else {
                    val dBefore = euclidean(points(tour(a)), points(tour((a + 1) % n))) + euclidean(points(tour(b)), points(tour((b + 1) % n)))
                    val dAfter = euclidean(points(tour(a)), points(tour(b))) + euclidean(points(tour((a + 1) % n)), points(tour((b + 1) % n)))
                    val tmpDiff = dAfter - dBefore
                    if (tmpDiff < diff) {
                        bestABsearch(a, b+1, a, b, tmpDiff)
                    } else {
                        bestABsearch(a, b+1, bestA, bestB, diff)
                    }
                }
            }
            val (aBest, bBest) = bestABsearch(0, 0+2, 0, 0, 99999999.0)

            tabuList.append(tour(aBest))
            if (tabuList.length > tl) {
                tabuList.removeHead()
            }

            val line = tour.take(aBest + 1) ++ tour.slice(aBest + 1, bBest + 1).reverse ++ tour.drop(bBest + 1)
            for (i <- 0 until n){
                tour(i) = line(i)
            }

            val tabuLength = calcLength(tour, n, points, 0, 0.0)
            if (tabuLength < length) {
                length = tabuLength
                for (i <- 0 until n) {
                    tourBest(i) = tour(i)
                }
            }
        }
        return tourBest
    }

    val Array(n, q, tl) = readLine().trim().split(" ").map(_.toInt)
    val points = Array.ofDim[Double](n, 2)
    for (i <- 0 until n) {
        points(i) = readLine().trim().split(" ").map(_.toDouble)
    }

    val tour = Array.ofDim[Int](n)
    for (i <- 0 until n) {
        tour(i) = readLine().trim().toInt
    }

    val result = tabuSearch(tour, q, tl, n, points, 0)
    result.foreach(println)
}
//解答例使用済み
//おそらくaBest, bBestはすべてのケースで正しいが、特定のケースで結果が異なる