import scala.io.StdIn._

object Main extends App {

    val n = readLine().trim().toInt
    
    def div2Count(cnt: Int, n: Int): Int = {
        if (n % 2 != 0){
            return cnt 
        } else {
            div2Count(cnt+1, n / 2)
        }
    }
    println(div2Count(0, n))
}
