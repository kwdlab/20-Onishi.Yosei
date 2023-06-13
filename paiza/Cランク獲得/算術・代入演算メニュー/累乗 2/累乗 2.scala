import scala.io.StdIn._

object Main extends App {

    val num = readLine().split(" ")
    val numA = num(0).toInt
    val numB = num(1).toInt
    val numC = num(2).toInt
    val numD = num(3).toInt

    val result = (numA+numB)*numC

    println(result*result%numD)
}
