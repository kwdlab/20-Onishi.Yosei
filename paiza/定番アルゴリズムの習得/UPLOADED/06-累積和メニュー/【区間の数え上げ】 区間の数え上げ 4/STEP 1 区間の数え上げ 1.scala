import scala.io.StdIn._

object Main extends App {

    val an = Array(1, 5, 9, 1, 20, 5, 3, 6, 5, 4)
    val n = an.length

    def twoPointersCount(a: Array[Int], n: Int): Int = {
        var right = 0
        var sum = 0
        var count = 0
        for (left <- 0 until n){
            while (right < n && sum + a(right) <= 15){
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


    val result = twoPointersCount(an, n)
    println(result)
}