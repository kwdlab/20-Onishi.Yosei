import scala.io.StdIn._

object Main extends App {

    val line = readLine().split(" ")
    val numA = line(0).toInt
    val numB = line(1).toInt

    if (numA == 1 && numB == 1){
        println(1)
    } else {
        println(0)
    }  
}
