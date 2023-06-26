import scala.io.StdIn._

object Main extends App {

    val n = readLine().trim().toInt
    
    @scala.annotation.tailrec
    def printDivisor(i: Int):Unit = {
        if (i <= n){
            if (n % i == 0) println(i)
            printDivisor(i+1)
        } 
    }
    printDivisor(1)
}