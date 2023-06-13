import scala.io.StdIn._

object Main extends App {

    val line = readLine().split(" ")
    val numX = line(0).toInt
    val numY = line(1).toInt
    val numZ = line(2).toInt

    if (numX >= 10 && numY >= 10 || numZ >= 10) {
        println("YES")
    } else {
        println("NO")
    }  
}
