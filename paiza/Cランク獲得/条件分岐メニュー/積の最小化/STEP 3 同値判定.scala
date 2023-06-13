import scala.io.StdIn._

object Main extends App {

    val numN = readLine().toInt
    val lineA = readLine.split(" ")
    val lineB = readLine.split(" ")
    var count = 0

    for (i <- 0 until numN){
        if (lineA(i) == lineB(i)){
            count = count + 1
        }
    }
    println(count)
}
