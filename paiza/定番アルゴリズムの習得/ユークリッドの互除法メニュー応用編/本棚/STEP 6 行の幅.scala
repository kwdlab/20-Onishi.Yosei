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
    def roopLCM(cnt: Int, leftLCM: Long): Long = {
        if (cnt < N-1){
            val tmp = readLine().trim().toLong - 1
            roopLCM(cnt+1, lcm(leftLCM, tmp))
        } else {
            return leftLCM
        }
    }
    
    val a = readLine().trim().toLong - 1
    println(roopLCM(0, a))
}