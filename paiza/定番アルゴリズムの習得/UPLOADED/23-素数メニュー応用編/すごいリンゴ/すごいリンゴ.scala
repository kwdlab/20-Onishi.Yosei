import scala.io.StdIn._

object Main extends App {

    val Array(a, b, c) = readLine().trim().split(" ").map(_.toInt)
    val gcdAB = gcd(a, b)
    val gcdABC = gcd(gcdAB, c)
    println(gcdABC)

    def gcd(a: Int, b: Int): Int = {
        if (b == 0) a
        else gcd(b, a % b)
    }
}
