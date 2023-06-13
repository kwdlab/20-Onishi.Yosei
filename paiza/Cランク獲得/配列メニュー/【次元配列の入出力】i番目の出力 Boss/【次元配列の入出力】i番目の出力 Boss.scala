import scala.io.StdIn._

object Main extends App {

    val line = readLine().split(" ")
    val numN = line(0).toInt
    val numK = line(1).toInt
    val lineA = readLine().split(" ")

    println(lineA(numK-1))
}