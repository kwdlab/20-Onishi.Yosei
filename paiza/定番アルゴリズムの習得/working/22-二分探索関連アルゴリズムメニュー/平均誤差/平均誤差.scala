import scala.io.StdIn._

object Main extends App {

    val n = readLine().trim().toInt
    val A = readLine().trim().split(" ").map(_.toInt)
    val m = readLine().trim().toInt
    val B = readLine().trim().split(" ").map(_.toInt)
    val k = readLine().trim().toInt

    def binarySearch(A: Array[Int], n: Int, k: Int): Int = {
        var left = 0
        var right = n

        while (left < right) {
            val mid = (left + right) / 2
            if (A(mid) < k)
            left = mid + 1
            else
            right = mid
        }
        return right
    }


    val sortedB = B.sorted
    var left = -1
    var right = 200000000

    while (right - left > 1) {
        val mid = (left + right) / 2
        var smaller = 0

        for (i <- 0 until n) {
            smaller += binarySearch(sortedB, sortedB.length, A(i) + mid + 1) -
            binarySearch(sortedB, sortedB.length, A(i) - mid)
        }

        if (smaller < k){
            left = mid        
        }
        else{
            right = mid
        }        
    }

    println(right)   
}

//解答例使用済み