import scala.io.StdIn._

object Main extends App {

    val line = readLine()
    val Head = line.head
    val Last = line.last

    if ((Head to 'Z').contains(Last)){
        println("true")
    } else {
        println("false")
    }
}
