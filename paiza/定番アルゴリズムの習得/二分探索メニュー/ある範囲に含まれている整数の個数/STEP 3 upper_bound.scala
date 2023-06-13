import scala.io.StdIn._

object Main extends App {

    val n = readLine().toInt
    val A = readLine().split(" ").map(_.toInt).sorted
    val q = readLine().toInt

    for (i <- 0 until q){
        val target = readLine().toInt
        println(n - binarySearch(A, n, target+1))
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