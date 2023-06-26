import scala.io.StdIn._

object Main extends App {

    val n = readLine().trim().toInt
    
    def gcd(a: Long, b: Long): Long = {
        if (b == 0){ a }
        else{ gcd(b, a % b) } 
    }
    def lcm(a: Long, b: Long): Long = {
        (a * b) / gcd(a, b)
    } 
    def roopDouble(cnt: Int, leftGCD: Long, leftLCM: Long): Array[Long] = {
        if (cnt < n-1){
            val tmp = readLine().trim().toLong
            roopDouble(cnt+1, gcd(leftGCD, tmp), lcm(leftLCM, tmp))
        } else {
            return Array(leftGCD, leftLCM)
        }
    }
    
    val a = readLine().trim().toLong
    val result = roopDouble(0, a, a)
    println(result.mkString(" "))
}