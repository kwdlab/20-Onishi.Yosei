import scala.io.StdIn._

object Main extends App {

    val n = readLine().toInt
    
    for (i <- 0 until n){
        val line = readLine().split(" ")
        println(line(1))
    }
}
