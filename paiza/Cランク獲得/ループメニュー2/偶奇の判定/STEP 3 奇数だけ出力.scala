import scala.io.StdIn._

object Main extends App {

    val num = readLine().toInt
    val lineA = readLine().split(" ")

    for (i <- 0 until num){
        if (lineA(i).toInt%2 != 0){
            println(lineA(i))
        }
    }
}
