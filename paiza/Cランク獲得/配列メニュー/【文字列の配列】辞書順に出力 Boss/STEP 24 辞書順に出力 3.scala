import scala.io.StdIn._

object Main extends App {

    val num = readLine().toInt
    val line = readLine().split(" ").sorted

    for (i <- line){
        println(i)
    }
}

