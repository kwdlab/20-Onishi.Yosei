import scala.io.StdIn._

object Main extends App {

    def gcd(a: Long, b: Long): Long = {
        if (b == 0){ a }
        else{ gcd(b, a % b) } 
    }
    def lcm(a: Long, b: Long): Long = {
        (a * b) / gcd(a, b)
    } 

    val Array(a, b) = readLine().trim().split(" ").map(_.toLong)
    println(lcm(a, b))
}
//解答例使用済み