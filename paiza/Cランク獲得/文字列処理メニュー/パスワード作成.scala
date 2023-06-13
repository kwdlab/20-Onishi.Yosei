import scala.io.StdIn._

object Main extends App {

    val N = readLine().toInt
    val Q = readLine().toInt
    var nc = Array.ofDim[String](Q, 2)

    for (i <- 0 until Q){
        nc(i) = readLine().split(" ")
    }
    val C = readLine()
    var pass = Array.fill(N)(C)

    for (i <- 0 until N){
        for (j <- 0 until Q){
            if (nc(j)(0).toInt-1 == i){
                pass(i) = nc(j)(1)
            }
        }
    }
    println(pass.mkString(""))
}