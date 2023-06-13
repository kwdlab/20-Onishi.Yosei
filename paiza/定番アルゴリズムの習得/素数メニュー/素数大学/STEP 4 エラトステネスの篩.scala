import scala.io.StdIn._

object Main extends App {

    val N = readLine().toInt
    val isPrime = Array.ofDim[Boolean](N+1)

    for (i <- 0 until N+1){
        isPrime(i) = true
    }
    isPrime(0) = false
    isPrime(1) = false

    for (i <- 2 until N+1){
        if (isPrime(i)){
            for (j <- i*2 until N+1 by i){
                isPrime(j) = false
            }
        }
    }

    if (isPrime(N)){
        println("YES")
    } else {
        println("NO")
    }
}