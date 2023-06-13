import scala.io.StdIn._

object Main extends App {

    val n = readLine().toInt
    val lineA = readLine().split(" ")
    val lineB = readLine().split(" ")

    for (i <- 0 until num){
        println(lineA(i).toInt - lineB(i).toInt)
    }
}
