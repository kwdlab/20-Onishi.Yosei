import scala.io.StdIn._

object Main extends App {

    val Array(n, x) = readLine().split(" ").map(_.toInt)
    val a = readLine().split(" ").map(_.toInt)

    def maxLength(cnt: Int, max: Int, current: Int): Int = {
        if (cnt == n){
            return max
        } else if (a(cnt) < x){
            maxLength(cnt+1, Array(max, current+1).max, current+1)
        } else {
            maxLength(cnt+1, max, 0)
        }
    }

    println(maxLength(0, 0, 0))
}