import scala.io.StdIn._

object Main extends App {

    val line = readLine()

    if (line.toUpperCase() == line) {
        println("YES")
    } else {
        println("NO")
    }  
}
