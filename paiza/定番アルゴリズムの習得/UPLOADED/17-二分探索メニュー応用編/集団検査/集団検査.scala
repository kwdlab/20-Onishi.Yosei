import scala.io.StdIn._

object Main extends App {

    val n = readLine().trim().toInt

    def massInspection(num: Int, ans: Int, n: Int):Int = {
        if (num < n) massInspection(num*2, ans+1, n)
        else ans
    }

    println(massInspection(1, 0, n))
}