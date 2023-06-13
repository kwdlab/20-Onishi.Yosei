import scala.io.StdIn._

object Main extends App {

    val line = readLine().split(" ")
    val numN = line(0).toInt
    val numM = line(1).toInt
    val numK = line(2).toInt
    val Aline = readLine().split(" ").map(_.toInt)

    val Cline = Aline.take(numM-1) ++ Array(numK) ++ Aline.drop(numM-1)

    for (i <- Cline){
        println(i)
    }
}
