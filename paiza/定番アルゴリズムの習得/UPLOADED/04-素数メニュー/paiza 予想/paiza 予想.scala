import scala.io.StdIn._
import math.sqrt

object Main extends App {

    val n = 100000000
    val isPrime = Array.fill(n+1)(true)
    eratosthenes(n)

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

    val ans: Array[Int] = (3 until sqrt(n).toInt+1 by 2).foldLeft(Array.empty[Int]) { (array, i) =>
        if (!(isPrime(i*i-2))) array :+ i*i
        else array
    }

    if (ans.length == 0) println("paiza's conjecture is correct.")
    else ans.foreach(println)
}