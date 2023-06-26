import scala.io.StdIn._

object Main extends App {

    val N = readLine().trim().toInt
    
    def gcd(a: Long, b: Long): Long = {
        if (b == 0){ a }
        else{ gcd(b, a % b) } 
    }
    def lcm(a: Long, b: Long): Long = {
        (a * b) / gcd(a, b)
    } 
    def roopDouble(cnt: Int, leftGCD: Long, leftLCM: Long): (Long, Long) = {
        if (cnt < N-1){
            val tmp = readLine().trim().toLong
            roopDouble(cnt+1, gcd(leftGCD, tmp), lcm(leftLCM, tmp))
        } else {
            return (leftGCD, leftLCM)
        }
    }
    
    val a = readLine().trim().toLong
    val (resGCD, resLCM) = roopDouble(0, a, a)
    println(resGCD)
    println(resLCM)
}