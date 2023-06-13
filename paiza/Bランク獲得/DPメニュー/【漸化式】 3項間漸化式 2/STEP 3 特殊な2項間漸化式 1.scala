import scala.io.StdIn._

object Main extends App {
     
    val xddk = readLine().split(" ")
    val x = xddk(0).toInt
    val d1 = xddk(1).toInt
    val d2 = xddk(2).toInt
    val k = xddk(3).toInt
     
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