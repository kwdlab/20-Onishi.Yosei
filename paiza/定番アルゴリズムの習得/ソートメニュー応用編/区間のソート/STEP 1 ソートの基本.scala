import scala.io.StdIn._

object Main extends App {
    val n = readLine().toInt
    val An = readLine().split(" ").map(_.toInt)

    if (An.sameElements(An.sorted)) {
        println("Yes")
    } else {
        println("No")
    }
}