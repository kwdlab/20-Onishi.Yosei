import scala.io.StdIn._

object Main extends App {

    val n = readLine().trim().toInt
    for (_ <- 0 until n){
        val tmp = printDivisor(readLine().trim().toInt, 1, Array.empty)
        println(tmp.mkString(" "))
    }
    
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