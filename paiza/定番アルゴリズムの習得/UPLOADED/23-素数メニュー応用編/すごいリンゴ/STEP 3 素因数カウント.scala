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
    def primeFactor(n: Int, isPrime:Array[Boolean], i: Int, result: Array[Int]): Array[Int] = {
        if (n >= i){
            if (isPrime(i) && n % i == 0){
                primeFactor(n/i, isPrime, i, result:+i)
            } else {
                primeFactor(n, isPrime, i+1, result)
            }
        } else {
            result
        }
    }
    
    val list = primeFactor(n, isPrime, 2, Array.empty[Int])
    val grouped = list.groupBy(identity)
    val maxOccurrences = grouped.maxBy(_._2.length)._2.length
    val modeElements = grouped.filter(_._2.length == maxOccurrences).keys.toSeq
    val modeElement = modeElements.max
    println(modeElement)
}