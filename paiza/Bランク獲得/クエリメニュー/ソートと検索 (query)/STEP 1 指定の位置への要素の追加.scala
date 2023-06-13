import scala.io.StdIn._

object Main extends App {
     
    val NKQ = readLine().split(" ")
    val N = NKQ(0).toInt
    val K = NKQ(1).toInt
    val Q = NKQ(2).toInt
    val An = Array.ofDim[Int](N)
        
    for (i <- 0 until N){
        An(i) = readLine().toInt
    }
    val result = An.take(K) ++ Array(Q) ++ An.drop(K)
    for (i <- result){
        println(i)
    }
}
