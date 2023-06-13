import scala.io.StdIn._

object Main extends App {

    val X = readLine().split("")
    val line1 = Array.ofDim[String](8)
    val line2 = Array.ofDim[String](8)
    val line3 = Array.ofDim[String](8)
    val line4 = Array.ofDim[String](8)

    for (i <- 0 until 8){
        line1(i) = X(i+0)
        line2(i) = X(i+8)
        line3(i) = X(i+16)
        line4(i) = X(i+24)
    }

    val result = line1.mkString("").toInt + line2.mkString("").toInt + line3.mkString("").toInt + line4.mkString("").toInt

    println(result)
}