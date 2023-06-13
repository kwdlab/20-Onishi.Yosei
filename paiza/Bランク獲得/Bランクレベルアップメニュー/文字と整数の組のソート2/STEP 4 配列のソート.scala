import scala.io.StdIn._

object Main extends App {

    val list = Array(1, 3, 5, 6, 3, 2, 5, 23, 2)
    
    for (i <- list.sorted){
        println(i)
    }
}
