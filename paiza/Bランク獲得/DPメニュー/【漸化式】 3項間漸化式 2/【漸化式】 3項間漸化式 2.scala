import scala.io.StdIn._

object Main extends App {
     
    val Q = readLine().toInt
    val a = Array.ofDim[Int](50)
        
    a(0) = 0   
    a(1) = 1
    a(2) = 1
    for (i <- 3 to 45){
        a(i) = a(i-2) + a(i-1)
    }

    for (j <- 0 until Q){
        val k = readLine().toInt
        println(a(k))
    }
}
