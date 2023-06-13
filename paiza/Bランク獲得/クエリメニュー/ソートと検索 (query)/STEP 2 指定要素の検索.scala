import scala.io.StdIn._

object Main extends App {
     
    val NKQ = readLine().split(" ")
    val N = NKQ(0).toInt
    val K = NKQ(1)
    val An = Array.ofDim[String](N)
        
    for (i <- 0 until N){
        An(i) = readLine()
    }

    if (An.contains(K)){
        println("YES")
    } else {
        println("NO")
    }
}
