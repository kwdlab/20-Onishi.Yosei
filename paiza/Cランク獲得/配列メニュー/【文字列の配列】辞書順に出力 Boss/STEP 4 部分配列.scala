import scala.io.StdIn._

object Main extends App {

    val line = readLine().split(" ")
    val numA = line(0).toInt
    val numB = line(1).toInt
    val numN = line(2).toInt
    val lineA = readLine().split(" ")

    for (i <- 0 until numN){
        if (numA-1 <= i && i <= numB-1){
            println(lineA(i))
        }
    }
}
