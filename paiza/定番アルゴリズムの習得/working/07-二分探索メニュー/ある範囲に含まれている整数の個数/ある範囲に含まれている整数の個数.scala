import scala.io.StdIn._

object Main extends App {

    val n = readLine().toInt
    val A = readLine().split(" ").map(_.toInt).sorted
    val q = readLine().toInt

    for (i <- 0 until q){
        val Array(l, r) = readLine().split(" ").map(_.toInt)
        val lpos = binarySearch(A, n, l)
        val rpos = binarySearch(A, n, r + 1)
        println(rpos - lpos)
    }

    def binarySearch(A: Array[Int], n: Int, target: Int): Int = {
        var left = 0
        var right = n
        while (left < right){
            val mid = (left + right) / 2

            if (A(mid) < target){
                left = mid + 1 
            } else {
                right = mid
            }
        }
        return right 
    }
}
//解答例使用済み