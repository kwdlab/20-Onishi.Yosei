//テスト3の入力値の末尾にのみ、なぜか指定にない空白が挿入されているため、数値型に変換するとエラーになる

import scala.io.StdIn._
import math.sqrt

object Main extends App {

    var N = readLine().toInt
    var primeFactor: Array[Int] = Array.empty
    println(N)
    
    for (i <- 2 until sqrt(N).toInt+1){
        while(N % i == 0){
            primeFactor = primeFactor ++ Array(i)
            N = N / i
        }
    }
    if (N != 1){
        primeFactor = primeFactor ++ Array(N)
    }
    primeFactor.foreach(println)
}


import scala.io.StdIn._

object Main extends App {

    val N = readLine().trim().toInt
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

    def primeFactor(N: Int, isPrime:Array[Boolean], i: Int): Unit = {
        if (N >= i){
            if (isPrime(i) && N % i == 0){
                println(i)
                primeFactor(N/i, isPrime, i)
            } else {
                primeFactor(N, isPrime, i+1)
            }
        }         
    }
    primeFactor(N, isPrime, 2)
}