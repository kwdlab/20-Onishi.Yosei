import scala.io.StdIn._

object Main extends App {

    val line = readLine().split(" ")
    val N = line(0).toInt
    val K = line(1).toInt
    val Nline = (1 to N)

    for (i <- 0 until K){
        println(Nline.mkString(" "))
    }
}