import scala.io.StdIn._

object Main extends App {

    val n = readLine().trim().toInt
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

    def primeFactor(n: Int, isPrime:Array[Boolean], i: Int): Unit = {
        if (n >= i){
            if (isPrime(i) && n % i == 0){
                println(i)
                primeFactor(n/i, isPrime, i)
            } else {
                primeFactor(n, isPrime, i+1)
            }
        }         
    }
    primeFactor(n, isPrime, 2)
}