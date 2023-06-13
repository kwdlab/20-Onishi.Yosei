import scala.io.StdIn._
import math._

object Main extends App {

    val n = readLine().toInt
    
    def loop(): Boolean = {
        for (a <- 1 to 1000; b <- 1 to 1000) {
            if (a > b){
                for (c <- 1 to 1000) {
                    if (n == a+b+c){
                        if (pow(a, 2) == pow(b, 2) + pow(c, 2)){
                            return false
                        }
                    }
                }
            }
        }
        return true
    }

    if (loop()){
        println("NO")
    } else {
        println("YES")  
    }
}