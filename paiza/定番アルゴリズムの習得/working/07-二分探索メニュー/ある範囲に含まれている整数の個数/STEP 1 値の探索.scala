import scala.io.StdIn._

object Main extends App {

    val n = readLine().toInt
    val A = readLine().split(" ").map(_.toInt)
    val q = readLine().toInt

    for (i <- 0 until q){
        val target = readLine().toInt
        if (binarySearch(A, n, target)){
            println("Yes")
        } else {
            println("No")
        }
    }

    def binarySearch(A: Array[Int], n: Int, target: Int): Boolean = {
        var left = 0
        var right = n-1
        while (left <= right){
            var mid = (left + right) / 2

            if (A(mid) == target){
                return true
            } else if (A(mid) < target){
                left = mid + 1 
            } else if (A(mid) > target){
                right = mid - 1
            }
        }
        return false 
    }
}
