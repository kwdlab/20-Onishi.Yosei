import scala.io.StdIn._

object Main extends App {

    val line = readLine().split(" ")
    val numA = line(0).toInt
    val numB = line(1).toInt

    val RList = List(numA*numA, numA*numB, numB*numB)
    println(RList.min)
}
