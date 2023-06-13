import scala.io.StdIn._

object Main extends App {
     
    val k = readLine().toInt
    val a = Array.ofDim[Int](k+1)
    
    a(0) = 0   
    a(1) = 1
    a(2) = 1
    for (i <- 3 to k){
        a(i) = a(i-2) + a(i-1)
    }

    println(a(k))
}
