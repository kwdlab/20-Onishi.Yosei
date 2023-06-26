import scala.io.StdIn._

object Main extends App {

    val Array(l, n, k) = readLine().trim().split(" ").map(_.toInt)
    val tmp = readLine().trim().split(" ").map(_.toInt)
    val A = Array(0) ++ tmp ++ Array(l)

    def binarySearch(left: Int, right: Int): Int = {
        if (right - left <= 1) {
            return left
        } else {
            val mid = (left + right) / 2

            def incParts(i: Int, last: Int, p: Int):Int = {
                if (i < k+2){
                    if (A(i) - A(last) >= mid) {
                        incParts(i+1, i, p+1)
                    } else {
                        incParts(i+1, last, p)
                    }
                } else {
                    return p
                }
            }

            val parts = incParts(0, 0, 0)
            if (parts < n) {
                binarySearch(left, mid)
            } else {
                binarySearch(mid, right)
            }
        }
    }

    val result = binarySearch(0, l+1)
    println(result)
}
//解答例使用済み

/*
import scala.io.StdIn._

object Main extends App {

    val Array(l, n, k) = readLine().trim().split(" ").map(_.toInt)
    val tmp = readLine().trim().split(" ").map(_.toInt)
    val A = Array(0) ++ tmp ++ Array(l)

    def binarySearch(left: Int, right: Int): Int = {
        if (right - left <= 1) {
            return left
        } else {
            val mid = (left + right) / 2

            var last = 0
            var parts = 0
            for (i <- 0 until k + 2) {
                if (A(i) - A(last) >= mid) {
                parts += 1
                last = i
                }
            }

            if (parts < n) {
                binarySearch(left, mid)
            } else {
                binarySearch(mid, right)
            }
        }
    }

    val result = binarySearch(0, l+1)
    println(result)
}
*/