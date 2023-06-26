import scala.io.StdIn._

object Main extends App {

    def gcd(a: Long, b: Long): Long = {
        if (b == 0) a 
        else gcd(b, a % b) 
    }
    def lcm(a: Long, b: Long): Long = {
        (a * b) / gcd(a, b)
    }

    def multipleLCM(numbers: Seq[Long]): Long = {
        numbers.reduce(lcm)
    } 

    val n = readLine().trim().toInt
    val numbers = (1 to n).map(_ => readLine().trim().toLong)
    println(multipleLCM(numbers))
}