import scala.io.StdIn._
import math.abs

object Main extends App {

    val n = readLine().trim().toInt
    val isPrime = Array.fill(n+1)(true)

    def eratosthenes(n: Int) = {
        isPrime(0) = false
        isPrime(1) = false
        for (i <- 2 until n+1){
            if (isPrime(i)){
                for (j <- i*2 until n+1 by i){
                    isPrime(j) = false
                }
            }
        }
    }
    def findPrimes(n: Int): Array[Int] = {
        var result = Array(1, 1, 2L)
        for (i <- 2 until n){
            val (p1, p2) = (i, abs(n-i))
            if ((isPrime(p1) && isPrime(p2)) && (result(2) < p1.toLong*p2.toLong)) result = Array(p1, p2, p1.toLong*p2.toLong)
        }
        return Array(result(0).toInt, result(1).toInt)
    }
    eratosthenes(n)
    findPrimes(n).foreach(println)
}