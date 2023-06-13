import scala.io.StdIn._

object Main extends App {

    val Array(n, k) = readLine().split(" ").map(_.toInt)
    val a = readLine().split(" ").map(_.toInt)

    def twoPointersLength(a: Array[Int], n: Int, k: Int): Int = {
        var right = 0
        var sum = 0
        var maxLen = 0
        for (left <- 0 until n){
            while (right < n && sum + a(right) <= k){
                sum = sum + a(right)
                right = right + 1
            }
            maxLen = maxLen.max(right - left)

            if (right == left){
                right = right + 1
            } else {
                sum = sum - a(left)
            }
        }
        return maxLen
    }

    val result = twoPointersLength(a, n, k)
    println(result)
}