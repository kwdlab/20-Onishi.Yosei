import scala.io.StdIn._

object Main extends App {

    val n = readLine().trim().toInt

    def searchMin(cnt: Int, min: Int): Int = {
        if (cnt == n){
            return min
        } else {
            val tmp = readLine.trim().toInt
            if (tmp < min){
                searchMin(cnt+1, tmp)
            } else {
                searchMin(cnt+1, min)
            }
        }
    }
    println(searchMin(0, Int.MaxValue))
}