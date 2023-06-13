import scala.io.StdIn._

object Main extends App {

    val n = readLine().trim().toInt

    def factorialTail(cnt: Int, n: Int): Int = {
        if (n <= 5){
            return cnt
        } else {
            factorialTail(cnt + n / 5, n / 5)
        }
    }
    println(factorialTail(0, n))
}

//http://fukiyo.g1.xrea.com/math-qa/kaijou.htm