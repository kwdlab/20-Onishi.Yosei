import scala.io.StdIn._

object Main extends App {

    val Array(n, x, a, b) = readLine().split(" ").map(_.toLong)

    def abSearch(cnt: Long, flag: Boolean):Boolean = {
        if (cnt <= n/a){
            val now = n - a*cnt
            val test = {
                if (now % b == 0 || ((now-x) >= 0 && (now-x) % b == 0)){
                    true
                } else {
                    flag
                }
            }
            abSearch(cnt+1, test)
        } else {
            return flag
        }
    }

    if (abSearch(0L, false)){
        println("Yes")
    } else {
        println("No")
    }
}
//解答例使用済み