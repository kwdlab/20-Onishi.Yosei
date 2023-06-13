import scala.io.StdIn._

object Main extends App {

    val line = readLine().split(" ")
    val numN = line(0).toInt
    val numA = line(1).toInt
    val numB = line(2).toInt

    if (numN+numA+numB==0 || numN+numA-numB==0 || numN-numA+numB==0 || numN-numA-numB==0) {
        println("YES")
    } else {
        println("NO")
    }
}
