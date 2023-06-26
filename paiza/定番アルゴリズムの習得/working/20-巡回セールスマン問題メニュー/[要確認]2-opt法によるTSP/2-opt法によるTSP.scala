import scala.io.StdIn._
import scala.math._

object Main extends App {

    var STATE : Long = 813L

    def euclidean(a: Array[Double], b: Array[Double]):Double = {
        return sqrt(pow(a(0)-b(0), 2) + pow(a(1)-b(1), 2))
    }
    def xorshift32(): Int = {
        var x : Long = STATE
        x ^= x << 13 & 0x7FFFFFFF
        x ^= x >> 17 & 0x7FFFFFFF
        x ^= x << 5 & 0x7FFFFFFF
        STATE = x & 0x7FFFFFFF
        return x.toInt
    }
    def pickTwo(n: Int): (Int, Int) = {
        while (true) {
            val a = xorshift32() % n
            val b = xorshift32() % n
            val (newA, newB) = {
                if (a > b) { (b, a) } else { (a, b) }
            } 
            if (!(newA + 1 < newB) || (newA == 0 && newB == n - 1)) {
            
            } else {
                return (newA, newB)
            }
        }
        return (0, 0)
    }
    def twoOpt(tour: Array[Int], n: Int, q: Int, points: Array[Array[Double]]): Array[Int] = {
        def innerLoop(line: Array[Int], cnt: Int): Array[Int] = {
            if (cnt == q){
                return line
            } else {
                val (a, b) = pickTwo(n)
                val dBefore = euclidean(points(line(a)), points(line((a + 1) % n))) + euclidean(points(line(b)), points(line((b + 1) % n)))
                val dAfter = euclidean(points(line(a)), points(line(b))) + euclidean(points(line((a + 1) % n)), points(line((b + 1) % n)))
                
                val tmp = {
                    if (dAfter < dBefore) {
                        line.take(a + 1) ++ line.slice(a + 1, b + 1).reverse ++ line.drop(b+1)
                    } else {
                        line
                    }
                }
                innerLoop(tmp, cnt+1)
            }
        }
        return innerLoop(tour, 0)
    }

    val Array(n, q) = readLine().trim().split(" ").map(_.toInt)
    val points = Array.ofDim[Double](n, 2)
    for (i <- 0 until n) {
        points(i) = readLine().trim().split(" ").map(_.toDouble)
    }

    val tour = Array.ofDim[Int](n)
    for (i <- 0 until n) {
        tour(i) = readLine().trim().toInt
    }

    val result = twoOpt(tour, n, q, points)
    result.foreach(println)
}
//解答例使用済み
//よくわからない上に厳しい