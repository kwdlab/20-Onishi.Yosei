import scala.io.StdIn._
import math.pow

object Main extends App {

    val n = readLine().trim().toInt
    val An = Array.ofDim[Int](n)
    val primeList = Array.fill(n)(Array.empty[Int])

    for (i <- 0 until n){
        An(i) = readLine().trim().toInt
    }

    val isPrime = Array.fill(An.max+1)(true)
    eratosthenes(An.max)
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
    def primeFactor(n: Int, isPrime:Array[Boolean], i: Int, index: Int): Unit = {
        if (n >= i){
            if (isPrime(i) && n % i == 0){
                primeList(index) = primeList(index) ++ Array(i)
                primeFactor(n/i, isPrime, i, index)
            } else {
                primeFactor(n, isPrime, i+1, index)
            }
        }         
    }

    for (i <- 0 until n){
        primeFactor(An(i), isPrime, 2, i)
    }

    val distinctMap = primeList.flatMap(_.toList).distinct
    val num = distinctMap.length
    val countList = Array.ofDim[Int](n, num)
    for (i <- 0 until n; j <- 0 until num){
        countList(i)(j) = primeList(i).count(_ == distinctMap(j))
    }

    val result = distinctMap.flatMap { factor =>
        val minExponent = countList.map(_(distinctMap.indexOf(factor))).min
        Array.fill(minExponent)(factor)
    }.product

    println(result)
}