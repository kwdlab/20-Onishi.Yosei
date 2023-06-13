import scala.io.StdIn._

object Main extends App {

    val Array(n, x) = readLine().split(" ").map(_.toLong)
    val a = readLine().split(" ").map(_.toLong).sorted.reverse

    def searchSumMinCount(cnt: Int, sum: Long): Long = {
        if (cnt == a.length){
            return -1L
        } else if (sum+a(cnt) >= x){
            return cnt + 1
        } else {
            searchSumMinCount(cnt+1, sum+a(cnt))
        }
    }

    println(searchSumMinCount(0, 0L))
}