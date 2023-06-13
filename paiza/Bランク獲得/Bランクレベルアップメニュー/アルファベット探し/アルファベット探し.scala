import scala.io.StdIn._

object Main extends App {

    val Head = readLine()
    val Last = readLine()
    val target = readLine()

    if (Head <= target && target <= Last){
        println("true")
    } else {
        println("false")
    }
}
