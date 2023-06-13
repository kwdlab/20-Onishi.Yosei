import scala.io.StdIn._

object Main extends App {

    def gcd(a: Long, b: Long): Long = {
        if (b == 0){ a }
        else{ gcd(b, a % b) } 
    }
    def lcm(a: Long, b: Long): Long = {
        (a * b) / gcd(a, b)
    } 

    val Array(a, b) = readLine().split(" ").map(_.toLong)
    val result = lcm(a, b)
    println(result)
}