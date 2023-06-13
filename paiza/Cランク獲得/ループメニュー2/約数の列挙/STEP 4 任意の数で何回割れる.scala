import scala.io.StdIn._

object Main extends App {

    val Array(n, m) = readLine().trim().split(" ").map(_.toInt)
    
    def divmCount(cnt: Int, n: Int): Int = {
        if (n % m != 0){
            return cnt
        } else {
            divmCount(cnt+1, n / m)
        }
    }
    println(divmCount(0, n))
}
