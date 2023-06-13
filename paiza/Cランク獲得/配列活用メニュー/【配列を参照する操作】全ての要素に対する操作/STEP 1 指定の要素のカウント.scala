import scala.io.StdIn._

object Main extends App {

    val Array(n, k) = readLine.trim().split(" ").map(_.toInt)

    def countTrue(cnt: Int, count: Int): Int = {
        if (cnt == n){
            return count
        } else {
            val tmp = readLine.trim().toInt
            if (tmp == k){
                countTrue(cnt+1, count+1)
            } else {
                countTrue(cnt+1, count)
            }
        }
    }
    println(countTrue(0, 0))
}