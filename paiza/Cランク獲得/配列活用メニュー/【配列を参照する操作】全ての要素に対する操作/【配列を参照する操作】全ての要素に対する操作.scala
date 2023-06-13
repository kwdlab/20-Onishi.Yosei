import scala.io.StdIn._

object Main extends App {

    val num = readLine.split(" ")
    val numN = num(0).toInt
    val numK = num(1).toInt

    for (i <- 0 until numN){
        val Anum = readLine().toInt
        println(Anum + numK)   
    }
}