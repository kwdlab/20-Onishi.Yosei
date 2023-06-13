import scala.io.StdIn._

object Main extends App {

    val line = readLine().split(" ")
    val numN = line(0).toInt
    val numM = line(1)
    val Aline = readLine().split(" ")
    var count = 0

    for (i <- 0 until numN){
        if (numM == Aline(i)){
            count = count + 1
        }
    }
    println(count)
}
