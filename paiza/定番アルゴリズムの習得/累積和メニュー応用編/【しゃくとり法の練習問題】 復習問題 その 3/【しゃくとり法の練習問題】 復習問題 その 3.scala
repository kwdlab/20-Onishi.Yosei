import scala.io.StdIn._

object Main extends App {

    val n = readLine().toInt
    val a = readLine().split(" ").map(_.toInt)

    def twoPointersLength(a: Array[Int], n: Int): Int = {
        var right = 0
        var maxLen = 0
        val color = Array.fill(55)(true)
        for (left <- 0 until n){
            while (right < n && color(a(right))){
                color(a(right)) = false
                right = right + 1
            }
            maxLen = maxLen.max(right - left)

            if (right == left){
                right = right + 1
            } else {
                color(a(left)) = true
            }
        }
        return maxLen
    }

    val result = twoPointersLength(a, n)
    println(result)
}
//解答例使用済み