import scala.io.StdIn._

object Main extends App {

    val num = readLine().toInt
    val line1 = readLine().split(" ")
    val line2 = readLine().split(" ")
    val line3= readLine().split(" ")
    val line4 = readLine().split(" ")
    val line5 = readLine().split(" ")

    val Dline = Array(line1, line2, line3, line4, line5)

    for (i <- 0 until Dline.length){
        println(Dline(i).mkString(" "))
    }
}
