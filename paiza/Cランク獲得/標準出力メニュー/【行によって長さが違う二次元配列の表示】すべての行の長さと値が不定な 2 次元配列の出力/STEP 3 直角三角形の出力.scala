import scala.io.StdIn._

object Main extends App {

    val n = readLine().toInt
    
    for (i <- 1 to n){
        println((1 to i).mkString(" "))
    }
}