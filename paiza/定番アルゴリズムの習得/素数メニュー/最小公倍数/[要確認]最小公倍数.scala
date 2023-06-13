import scala.io.StdIn._

object Main extends App {

    def gcd(a: Long, b: Long): Long = {
        if (b == 0){ a }
        else{ gcd(b, a % b) } 
    }
    def lcm(a: Long, b: Long): Long = {
        (a * b) / gcd(a, b)
    } 

    def multipleLCM(numbers: Seq[Long]): Long = {
        numbers.reduce(lcm)
    } 

    val N = readLine().trim().toInt
    val numbers = (1 to N).map(_ => readLine().trim().toLong)
    val result = multipleLCM(numbers)
    println(result)
}

//最小構成
//断念