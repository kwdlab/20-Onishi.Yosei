import scala.io.StdIn._

object Main extends App {

    val Array(n, m, k) = readLine().split(" ").map(_.toInt)
    val a = Array.fill(n)(readLine().split(" ").map(_.toInt))

    def countUp(count: Int, i: Int, j: Int): Int = {
        if (i == n-1){
            return count
        } else if (j == m-1){
            countUp(count, i+1, 0)
        } else {
            if (a(i)(j)==a(i)(j+1) && a(i)(j)==a(i+1)(j) && a(i)(j)==a(i+1)(j+1)){
                countUp(count+1, i, j+1)
            } else {
                countUp(count, i, j+1)
            }
        }
    }
    val result = countUp(0, 0, 0)
    println(result)
}
