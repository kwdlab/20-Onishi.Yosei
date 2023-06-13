import scala.io.StdIn._

object Main extends App {

    val line = readLine().split(" ")
    val numK = line(0).toInt
    val numL = line(1).toInt
    
    val line1 = Array(1, 2, 3, 4)
    val line2 = Array(10, 100, 0, 5)
    val line3 = Array(8, 1, 3, 8)
    val line4 = Array(15, 34, 94, 25)
    val Dline = Array(line1, line2, line3, line4)

    println(Dline(numK-1)(numL-1))
}
