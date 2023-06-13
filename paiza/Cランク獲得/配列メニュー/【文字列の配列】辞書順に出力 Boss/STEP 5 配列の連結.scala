import scala.io.StdIn._

object Main extends App {

    val line = readLine().split(" ")
    val numN = line(0).toInt
    val numM = line(1).toInt
    val Aline = readLine().split(" ")
    val Bline = readLine().split(" ")

    val Cline = Aline ++ Bline

    for (i <- 0 until numN+numM){
        println(Cline(i))
    }
}
