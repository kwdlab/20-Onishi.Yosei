import scala.io.StdIn._

object Main extends App {

    val Array(a, b) = readLine().trim().split(" ").map(_.toInt)
    val paiza = printDivisor(a, 1, Array.empty).sum - a
    val izapa = printDivisor(b, 1, Array.empty).sum - b

    if (paiza > izapa) println("paiza")
    else if (paiza < izapa) println("izapa")
    else println("draw")
    
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