import scala.io.StdIn._

object Main extends App {

    val n = readLine().trim().toInt
    val weights = readLine().trim().split(" ").map(_.toInt)
    val aLine = Array.ofDim[Int](n, 5)
    val rLine = Array.ofDim[Int](n)

    for (i <- 0 until n){
        aLine(i) = readLine().trim().split(" ").map(_.toInt)
    }

    def searchMax(cnt: Int, max: Int): Int = {
        if (cnt == n){
            return max
        } else {
            val score =  aLine(cnt).zip(weights).map { case (line, weight) => line * weight }
            if (score.sum > max){
                searchMax(cnt+1, score.sum)
            } else {
                searchMax(cnt+1, max)
            }
        }
    }
    println(searchMax(0, 0))
}