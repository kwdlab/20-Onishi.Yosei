import scala.io.StdIn._

object Main extends App {

    val line = readLine().split(" ")
    val numN = line(0).toInt
    val numM = line(1).toInt
    val Aline = readLine().split(" ").map(_.toInt)

    val Cline = Aline.take(numM-1) ++ Aline.drop(numM)

    for (i <- Cline){
        println(i)
    }
}
