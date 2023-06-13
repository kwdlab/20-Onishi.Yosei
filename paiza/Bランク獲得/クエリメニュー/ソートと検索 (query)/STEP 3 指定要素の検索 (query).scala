import scala.io.StdIn._

object Main extends App {
     
    val NQ = readLine().split(" ")
    val N = NQ(0).toInt
    val Q = NQ(1).toInt
    val An = Array.ofDim[String](N)
    val Kq = Array.ofDim[String](Q)
        
    for (i <- 0 until N){
        An(i) = readLine()
    }
    val listA = An.toSet 

    for (i <- 0 until Q){
        if (listA.contains(readLine())){
            println("YES")
        } else {
            println("NO")
        }    
    }
}

/*
import scala.io.StdIn._

object Main extends App {
     
    val NQ = readLine().split(" ")
    val N = NQ(0).toInt
    val Q = NQ(1).toInt
    val An = Array.ofDim[String](N)
    val Kq = Array.ofDim[String](Q)
        
    for (i <- 0 until N){
        An(i) = readLine()
    }
    for (i <- 0 until Q){
        Kq(i) = readLine()
    }

    for (i <- Kq){
        if (An.contains(i)){
            println("YES")
        } else {
            println("NO")
        }        
    }
}
*/