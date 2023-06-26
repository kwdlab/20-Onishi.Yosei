import scala.io.StdIn._

object Main extends App {

    val N = readLine().trim().toInt
    val isPrime = Array.fill(N+1)(true)
    var primeList: Array[Int] = Array.empty
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
                primeList = primeList ++ Array(i)
                primeFactor(N/i, isPrime, i)
            } else {
                primeFactor(N, isPrime, i+1)
            }
        }         
    }
    primeFactor(N, isPrime, 2)
    
    var result = 1
    for (i <- primeList.distinct){
        val tmp = primeList.count(_ == i) + 1
        result = result * tmp
    }
    println(result)
}