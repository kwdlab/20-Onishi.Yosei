import scala.io.StdIn._

object Main extends App {

    val line = readLine().split(" ")
    val numN = line(0).toInt
    val numM = line(1)
    val Aline = readLine().split(" ")

    val Cline = Aline ++ numM

    for (i <- 0 until numN+1){
        println(Cline(i))
    }
}
