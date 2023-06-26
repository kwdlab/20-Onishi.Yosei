import scala.io.StdIn._

object Main extends App {

    val s = readLine()
    
    for (i <- 'a' to 'z'){
        println(s.count(_ == i))
    }
}
