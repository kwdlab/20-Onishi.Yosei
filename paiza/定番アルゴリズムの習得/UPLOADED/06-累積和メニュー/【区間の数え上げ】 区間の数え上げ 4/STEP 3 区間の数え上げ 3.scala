import scala.io.StdIn._

object Main extends App {

    val k = readLine().toInt
    val an = readLine().split(" ").map(_.toInt)
    val n = an.length

    def twoPointersCount(a: Array[Int], n: Int, k: Int): Int = {
        var right = 0
        var sum = 0
        var count = 0
        for (left <- 0 until n){
            while (right < n && sum + a(right) <= k){
                sum = sum + a(right)
                right = right + 1
            }
            count = count + (right - left)

            if (right == left){
                right = right + 1
            } else {
                sum = sum - a(left)
            }
        }
        return count
    }


    val result = twoPointersCount(an, n, k)
    println(result)
}