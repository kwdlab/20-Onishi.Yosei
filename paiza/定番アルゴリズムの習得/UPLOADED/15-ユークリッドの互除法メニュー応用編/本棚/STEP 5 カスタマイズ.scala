import scala.io.StdIn._

object Main extends App {

    val N = readLine().trim().toInt
    
    def gcd(a: Long, b: Long): Long = {
        if (b == 0){ a }
        else{ gcd(b, a % b) } 
    }
    def roopGCD(cnt: Int, leftGCD: Long): Long = {
        if (cnt < N-1){
            val tmp = readLine().trim().toLong
            roopGCD(cnt+1, gcd(leftGCD, tmp))
        } else {
            return leftGCD
        }
    }
    
    val a = readLine().trim().toLong
    println(roopGCD(0, a))
}