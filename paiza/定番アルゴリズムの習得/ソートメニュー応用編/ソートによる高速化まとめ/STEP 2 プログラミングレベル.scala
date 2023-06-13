import scala.io.StdIn._

object Main extends App {

    val n = readLine().toInt
    val a = readLine().split(" ").map(_.toLong).sorted

    def loop(cnt: Int, level: Long):Boolean = {
        if (cnt == n){
            return true
        } else if (a(cnt) <= level) {
            loop(cnt+1, a(cnt)+1)
        } else {
            return false
        }
    }

    if (loop(0, 1L)) {
        println("Yes")
    } else {
        println("No")
    }
}