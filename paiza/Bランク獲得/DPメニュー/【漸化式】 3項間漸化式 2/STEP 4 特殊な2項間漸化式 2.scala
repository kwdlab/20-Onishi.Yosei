import scala.io.StdIn._

object Main extends App {
     
    val xdd = readLine().split(" ")
    val x = xdd(0).toInt
    val d1 = xdd(1).toInt
    val d2 = xdd(2).toInt
    val Q = readLine().toInt

    for (i <- 0 until Q){
        val k = readLine().toInt
        val a = Array.ofDim[Int](k+1)
        a(0) = 0   
        a(1) = x
        for (j <- 2 to k){
            if (j % 2 == 0){
                a(j) = a(j-1) + d2
            } else {
                a(j) = a(j-1) + d1           
            }
        }
        println(a(k))        
    }
}
