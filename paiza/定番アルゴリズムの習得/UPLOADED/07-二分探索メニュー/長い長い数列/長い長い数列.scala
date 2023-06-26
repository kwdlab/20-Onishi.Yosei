import scala.io.StdIn._

object Main extends App {

    val n = readLine().trim().toInt
    val an = readLine().trim().split(" ").map(_.toInt)
    val m = readLine().trim().toInt
    val bm = readLine().trim().split(" ").map(_.toInt).sorted
    val k = readLine().trim().toInt

    @scala.annotation.tailrec
    def binarySearch(exit: (Int, Int) => Boolean)(an: Array[Int], left: Int, right: Int, target: Int): Int = {
        if (exit(left, right)) right
        else {
            val mid = (left + right) / 2
            if (an(mid) < target) binarySearch(exit)(an, mid + 1, right, target) 
            else binarySearch(exit)(an, left, mid, target)
        }
    }

    var left = -1
    var right = 200000000

    while (right - left > 1) {
        val mid = (left + right) / 2
        val smaller = (0 until n).foldLeft(0) { (sum, i) =>
            sum + binarySearch((l: Int, r: Int) => l >= r)(bm, 0, m, an(i) + mid + 1) - binarySearch((l: Int, r: Int) => l >= r)(bm, 0, m, an(i) - mid)
        }
        if (smaller < k) left = mid
        else right = mid
    }

    println(right)   
}
//解答例使用済み