import scala.io.StdIn._

object Main extends App {

    val n = readLine().toInt
    val a = readLine().split(" ").map(_.toInt)

    def maxLength(cnt: Int, max: Int, current: Int, x: Int): Int = {
        if (cnt == n){
            return max
        } else if (a(cnt) == x){
            maxLength(cnt+1, Array(max, current+1).max, current+1, x)
        } else {
            maxLength(cnt+1, max, 1, a(cnt))
        }
    }

    println(maxLength(0, 0, 0, a(0)))
}