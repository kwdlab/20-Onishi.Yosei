import scala.io.StdIn._

object Main extends App {

    val Array(a, b, c) = readLine().trim().split(" ").map(_.toInt)
    val lcmAB = lcm(a, b)
    val lcmABC = lcm(lcmAB, c)
    println(lcmABC)

    def gcd(a: Int, b: Int): Int = {
        if (b == 0) a
        else gcd(b, a % b)
    }  
    def lcm(a: Int, b: Int): Int = {
        a * b / gcd(a, b)
    }
}
