import scala.io.StdIn._

object Main extends App {

    val n = readLine().trim().toInt
    val tmp = printDivisor(n, 1, Array.empty)
    if (tmp.sum == n*2) println("Yes")
    else println("No")
    
    @scala.annotation.tailrec
    def printDivisor(n: Int, i: Int, result: Array[Int]):Array[Int] = {
        if (i <= n){
            if (n % i == 0) printDivisor(n, i+1, result:+i)
            else printDivisor(n, i+1, result)
        } else {
            result
        }
    }
}