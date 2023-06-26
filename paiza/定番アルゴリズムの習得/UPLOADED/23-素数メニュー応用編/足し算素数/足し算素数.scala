import scala.io.StdIn._
import math._

object Main extends App {

    @scala.annotation.tailrec
    def isPrime(n: Long, i: Long): Boolean = {
        if (i > sqrt(n)) true
        else if (n % i == 0) false
        else isPrime(n, i + 1)
    }

    val abc = readLine().split(" ").map(_.toLong)
    val select = abc.combinations(2).map(_.sum).map(isPrime(_, 2))
    if (select.exists(_ == true)) println("Yes") else println("No")
}