import scala.io.StdIn._

object Main extends App {

    val num = readLine().toInt
    val line = Array(1, 5, 9, 7, 3, 2, 4, 8, 6, 10)

    for (i <- 0 until line.length){
        if (line(i) == num){
            println(i+1)
        }
    }
}
