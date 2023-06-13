import scala.io.StdIn._

object Main extends App {
     
    val xdk = readLine().split(" ")
    val x = xdk(0).toInt
    val d = xdk(1).toInt
    val k = xdk(2).toInt
     
    var a = Array.ofDim[Int](k+1)
    a(0) = 0   
    a(1) = x
    for (i <- 2 to k){
        a(i) = a(i-1) + d
    }

    println(a(k))
}
