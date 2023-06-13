import scala.io.StdIn._

object Main extends App {

    val numX = readLine().toInt

    if (!(numX >= 10)) {
        println("YES")
    } else {
        println("NO")
    }  
}
