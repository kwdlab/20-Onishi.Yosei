import scala.io.StdIn._

object Main extends App {
     
    val N = readLine().toInt
    val An = Array.ofDim[String](N)
        
    for (i <- 0 until N){
        An(i) = readLine()
    }

    val result = An.drop(1)
    
    for (i <- result){
        println(i)
    }
}
