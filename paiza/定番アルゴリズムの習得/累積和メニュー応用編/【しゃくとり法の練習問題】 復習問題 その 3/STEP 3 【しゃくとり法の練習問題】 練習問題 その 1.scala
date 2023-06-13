import scala.io.StdIn._

object Main extends App {

    val Array(n, k) = readLine().split(" ").map(_.toInt)
    val a = readLine().split(" ").map(_.toInt)

    def twoPointersLength(a: Array[Int], n: Int, k: Int): Int = {
        var right = 0
        var sum = 0
        var minLen = n+1
        for (left <- 0 until n){
            while (right < n && sum <= k){
                sum = sum + a(right)
                right = right + 1
            }
            if (sum > k){
                minLen = minLen.min(right - left)
                sum = sum - a(left)
            }           
        }
        if (minLen == n+1){
            return -1
        } else {
            return minLen
        }
    }

    val result = twoPointersLength(a, n, k)
    println(result)
}