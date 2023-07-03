import scala.io.StdIn._

object Main extends App {

    def lowerBound(arr: Array[Int], target: Int): Int = {
        var left = 0
        var right = arr.length
        while (left < right) {
            val mid = left + (right - left) / 2
            if (arr(mid) < target) {
                left = mid + 1
            } else {
                right = mid
            }
        }
        return left
    }
    def upperBound(arr: Array[Int], target: Int): Int = {
        var left = 0
        var right = arr.length
        while (left < right) {
        val mid = left + (right - left) / 2
            if (arr(mid) <= target) {
                left = mid + 1
            } else {
                right = mid
            }
        }
        return left
    }

    val n = readLine().toInt
    val al = Array.ofDim[Int](n, 2)
    for (i <- 0 until n) {
        al(i) = readLine().trim.split(" ").map(_.toInt)
    }

    val aSorted = al.map(_(0)).sorted
    val lSorted = al.map(_(1)).sorted

    for (i <- 0 until n) {
        val before = lowerBound(lSorted, al(i)(0))
        val after = n - upperBound(aSorted, al(i)(1))
        println(n - 1 - (before + after))
    }
}

//解答例使用済み