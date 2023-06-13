import scala.io.StdIn._

object Main extends App {

    val num = readLine().split(" ")
    val numN = num(0).toInt
    val line = readLine().split(" ")
    
    println(line(numN-1))
}
