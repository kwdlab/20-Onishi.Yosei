import scala.io.StdIn._

object Main extends App {

    val line = readLine().split(" ")
    val numN = line(0).toInt
    val numM = line(1).toInt
    val lineA = readLine().split(" ")

    for (i <- 0 until numM){
        if (lineA(i).toInt == numN){
            println(i+1)
        }
    }
}
