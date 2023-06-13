import scala.io.StdIn._
import math._

object Main extends App {
    
    val NK = readLine().split(" ").map(_.toInt)
    val N = NK(0)
    val K = NK(1)
    val An = Array.ofDim[Int](N+1)
    val limit = (N/3.0)

    for(i <- 1 to N){
        An(i) = An(i-1) + readLine().toInt
    }

    def main() = {
        for(i <- 0 until K){
            val lr = readLine().split(" ").map(_.toInt)
            val Al = lr(0)
            val Ar = lr(1)
            val Bl = lr(2)
            val Br = lr(3)
            if (Ar-Al+1 >= limit && Br-Bl+1 >= limit){
                println("DRAW")
            } else if (Ar-Al+1 >= limit){
                println("B")
            } else if (Br-Bl+1 >= limit){
                println("A")
            } else {
                val countA = An(Ar) - An(Al-1)
                val countB = An(Br) - An(Bl-1)

                if (countA > countB){
                    println("A")
                } else if (countA < countB){
                    println("B")
                } else {
                    println("DRAW")
                }
            }  
        }        
    }

    main()
}
