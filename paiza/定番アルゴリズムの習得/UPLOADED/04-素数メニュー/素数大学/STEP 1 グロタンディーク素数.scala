import scala.io.StdIn._

object Main extends App {

    val N = 52
    
    val flag = if (N == 1){ false } else { isPrime(N) }

    def isPrime(n: Long): Boolean = {
        if (n < 2) {return false}
        else if (n == 2 || n == 3) {return true}
        else if (n % 2 == 0 || n % 3 == 0) {return false}

        val sqrtN = sqrt(n).toLong
        var i = 5
        while (i <= sqrtN) {
            if (n % i == 0 || n % (i + 2) == 0) {return false}
            i = i + 6
        }
        return true
    }

    if (flag){
        println("YES")
    } else {
        println("NO")
    }
}