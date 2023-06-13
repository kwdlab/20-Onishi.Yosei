import scala.io.StdIn._

object Main extends App {
     
    val xd = readLine().split(" ")
    val x = xd(0).toInt
    val d = xd(1).toInt
    val Q = readLine().toInt
     
    for (i <- 0 until Q){    
        val k = readLine().toInt
        val a = Array.ofDim[Int](k+1)
        a(0) = 0   
        a(1) = x
        for (j <- 2 to k){
            a(j) = a(j-1) + d
        }
        println(a(k))
    }
}
