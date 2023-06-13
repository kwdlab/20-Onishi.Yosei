import scala.io.StdIn._
import Math._

object Main extends App {

    val num = readLine().split(" ")
    val numN = num(0).toInt    
    val numA = num(1).toInt    
    val numB = num(2).toInt

    var ABline = Array.ofDim[Int](numN, 2)

    for (i <- 0 until numN){
        val line = readLine().split(" ").map(_.toInt)
        ABline(i) = line
    }

    val result = abs(ABline(numA-1)(0)-ABline(numB-1)(0)) + abs(ABline(numA-1)(1)-ABline(numB-1)(1))
    println(result)
}
