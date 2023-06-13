import scala.io.StdIn._
import math.sqrt

object Main extends App {

    val N = 100000000
    val isPrime = Array.fill(N+1)(true)
    eratosthenes(N)

    def eratosthenes(N: Int) = {
        isPrime(0) = false
        isPrime(1) = false
        for (i <- 2 until N+1){
            if (isPrime(i)){
                for (j <- i*2 until N+1 by i){
                    isPrime(j) = false
                }
            }
        }
    }

    var ans : Array[Int] = Array.empty
    for (i <- 3 until sqrt(N).toInt+1 by 2){
        if (!(isPrime(i*i-2))){
            ans = ans ++ Array(i*i)
        }
    }
    if (ans.length == 0){
        println("paiza's conjecture is correct.")
    } else {
        for(i <- ans){
            println(i)
        } 
    }
}
//解答例使用済み