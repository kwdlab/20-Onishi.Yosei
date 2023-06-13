import scala.io.StdIn._

object Main extends App {

    val num = readLine().toInt
    val line = Array(5, 12, 6, 84, 14, 25, 44, 3, 7, 20)

    if (line.contains(num)){
        println("Yes")
    } else {
        println("No")
    }
}
