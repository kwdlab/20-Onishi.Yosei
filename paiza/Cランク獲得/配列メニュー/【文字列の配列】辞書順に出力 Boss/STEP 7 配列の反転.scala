import scala.io.StdIn._

object Main extends App {

    val numN = readLine().toInt
    val Aline = readLine().split(" ").reverse

    for (i <- 0 until numN){
        println(Aline(i))
    }
}
