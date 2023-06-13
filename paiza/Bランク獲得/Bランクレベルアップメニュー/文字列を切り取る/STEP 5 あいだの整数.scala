import scala.io.StdIn._

object Main extends App {

    val ab = readLine().split(" ").map(_.toInt)

    for (i <- ab(0) to ab(1)){
        println(i)
    }
}
