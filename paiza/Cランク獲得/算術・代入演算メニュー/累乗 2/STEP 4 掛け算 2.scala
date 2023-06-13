import scala.io.StdIn._

object Main extends App {

    val line = readLine().split(" ")
    val numA = line(0).toInt
    val numB = line(1).toInt
    val numC = line(2).toInt

    println(s"${numA*numA} ${numB*numB + numC*numC}")
}
