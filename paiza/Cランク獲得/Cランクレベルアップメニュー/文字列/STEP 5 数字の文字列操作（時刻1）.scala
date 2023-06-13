import scala.io.StdIn._

object Main extends App {

    val S = readLine().split(":").map(_.toInt)
    
    for (i <- S){
        println(i)
    }
}