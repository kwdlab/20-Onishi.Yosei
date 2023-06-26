import scala.io.StdIn._
import math._

object Main extends App {

    val n = readLine().toLong    
    val flag = if (n == 1) false else isPrime(n)

    def isPrime(n: Long): Boolean = {
        if (n < 2) false
        else if (n == 2 || n == 3) true
        else if (n % 2 == 0 || n % 3 == 0) false

        else {
            val sqrtN = sqrt(n).toLong
            def checkPrime(i: Long): Boolean = {
                if (i > sqrtN) true
                else if (n % i == 0 || n % (i + 2) == 0) false
                else checkPrime(i + 6)
            }
            checkPrime(5)
        }
    }

    if (flag) println("Yes") else println("No")
}