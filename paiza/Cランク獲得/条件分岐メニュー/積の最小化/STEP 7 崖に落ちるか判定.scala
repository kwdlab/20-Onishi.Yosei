import scala.io.StdIn._

object Main extends App {

    val line = readLine.split(" ")
    val numN = line(0).toInt
    val numK = line(1).toInt
    val numT = line(2).toInt

    if (numN * numK <= (numT+0.1)){
        println("YES")
    } else {
        println("NO")
    }
}
