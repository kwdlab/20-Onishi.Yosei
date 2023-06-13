import scala.io.StdIn._

object Main extends App {

    val num = readLine().toInt
    val line = readLine().split(" ").map(_.toInt)

    for (i <- line){
        if (i >= 5){
            println(i)
        }
    }
}
