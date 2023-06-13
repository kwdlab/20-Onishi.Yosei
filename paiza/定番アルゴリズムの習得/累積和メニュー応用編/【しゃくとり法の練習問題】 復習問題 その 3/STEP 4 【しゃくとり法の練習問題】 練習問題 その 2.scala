import scala.io.StdIn._

object Main extends App {

    val n = readLine().toInt
    val a = readLine().split(" ").map(_.toInt)

    def twoPointersCount(a: Array[Int], n: Int): Int = {
        var right = 0
        var count = 0
        for (left <- 0 until n){
            while (right < n && (right==left || a(right-1) <= a(right))){
                right = right + 1
            }
            count = count + (right - left)
        }
        return count
    }

    val result = twoPointersCount(a, n)
    println(result)
}
//解答例使用済み