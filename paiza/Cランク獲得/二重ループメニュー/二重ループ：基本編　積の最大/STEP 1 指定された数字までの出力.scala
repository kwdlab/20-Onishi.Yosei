import scala.io.StdIn._

object Main extends App {

    val num = readLine().toInt
    val result = (1 to num)
    
    println(result.mkString(" "))
}