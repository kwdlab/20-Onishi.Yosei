import scala.io.StdIn._
import math.pow

object Main extends App {

    val N = readLine().trim().toInt
    val An = Array.ofDim[Int](N)
    val primeList = Array.fill(N)(Array.empty[Int])

    for (i <- 0 until N){
        An(i) = readLine().trim().toInt
    }

    val isPrime = Array.fill(An.max+1)(true)
    eratosthenes(An.max)
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
    def primeFactor(N: Int, isPrime:Array[Boolean], i: Int, index: Int): Unit = {
        if (N >= i){
            if (isPrime(i) && N % i == 0){
                primeList(index) = primeList(index) ++ Array(i)
                primeFactor(N/i, isPrime, i, index)
            } else {
                primeFactor(N, isPrime, i+1, index)
            }
        }         
    }

    for (i <- 0 until N){
        primeFactor(An(i), isPrime, 2, i)
    }

    val distinctMap = primeList.flatMap(_.toList).distinct
    val num = distinctMap.length
    val countList = Array.ofDim[Int](N, num)
    for (i <- 0 until N; j <- 0 until num){
            countList(i)(j) = primeList(i).count(_ == distinctMap(j))
    } 
    /*
    val result = Array.ofDim[Int](num)
    for (i <- 0 until num){
        result(i) = pow(distinctMap(i), countList(i).min).toInt
    }
    println(result.product)
    */
    val result = distinctMap.flatMap { factor =>
    val minExponent = countList.map(_(distinctMap.indexOf(factor))).min
    Array.fill(minExponent)(factor)
    }.product

    println(result)

}