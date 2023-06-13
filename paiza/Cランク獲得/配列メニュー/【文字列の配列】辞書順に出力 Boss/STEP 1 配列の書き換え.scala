import scala.io.StdIn._

object Main extends App {

    val line = readLine().split(" ")
    val numA = line(0)
    val numB = line(1)
    val numN = line(2).toInt
    var lineA = readLine().split(" ")

    for (i <- 0 until numN){
        if (lineA(i) == numA){
            lineA(i) = numB
        }
        println(lineA(i))
    }
}
