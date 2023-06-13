import scala.io.StdIn._

object Main extends App {

    val line = readLine.split(" ")
    var numN = line(0).toInt
    val numK = line(1).toInt
    var count = 0

    while (numN < numK){
        numN = numN * 2 
        count = count + 1
    }
    println(count)
}
