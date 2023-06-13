import scala.io.StdIn._

object Main extends App {

    val n = readLine().trim().toInt

    def searchMax(cnt: Int, max: Int): Int = {
        if (cnt == n){
            return max
        } else {
            val tmp = readLine.trim().toInt
            if (tmp > max){
                searchMax(cnt+1, tmp)
            } else {
                searchMax(cnt+1, max)
            }
        }
    }
    println(searchMax(0, 0))
}