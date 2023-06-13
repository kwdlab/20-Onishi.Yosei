import scala.io.StdIn._

object Main extends App {

    val line = readLine().split(" ").sorted

    for (i <- line){
        println(i)
    }
}

