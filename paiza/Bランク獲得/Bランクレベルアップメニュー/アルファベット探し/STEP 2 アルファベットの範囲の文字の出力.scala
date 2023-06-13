import scala.io.StdIn._

object Main extends App {

    val line = readLine()
    val Head = line.head
    val Last = line.last

    for(i <- Head to Last){
        println(i)
    }
}
