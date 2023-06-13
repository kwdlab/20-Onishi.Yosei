import scala.io.StdIn._

object Main extends App {

    val line = readLine().split(" ")
    val numA = line(0).toInt

    if (numA == 1){
        println(0)
    } else {
        println(1)
    }  
}
