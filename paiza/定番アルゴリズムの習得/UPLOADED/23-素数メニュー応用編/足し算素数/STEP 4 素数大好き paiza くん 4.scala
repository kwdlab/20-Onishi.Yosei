import scala.io.StdIn._
import math._

object Main extends App {

    def findLargestPrime(n: Long): Long = {
        @scala.annotation.tailrec
        def isPrime(n: Long, i: Long): Boolean = {
            if (i > sqrt(n)) true
            else if (n % i == 0) false
            else isPrime(n, i + 1)
        }

        @scala.annotation.tailrec
        def searchPrime(num: Long): Long = {
            if (isPrime(num, 2)) num
            else searchPrime(num - 1)
        }
        searchPrime(n)
    }

    val n = readLine().toLong
    println(findLargestPrime(n))
}