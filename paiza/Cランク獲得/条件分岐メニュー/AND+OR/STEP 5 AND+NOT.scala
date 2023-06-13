import scala.io.StdIn._

object Main extends App {

    val line = readLine().split(" ")
    val numA = line(0).toInt
    val numB = line(1).toInt

    if (numA >= 10 && !(numB >= 10)) {
        println("YES")
    } else {
        println("NO")
    }  
}
