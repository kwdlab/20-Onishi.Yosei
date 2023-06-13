import scala.io.StdIn._

object Main extends App {

    val line = readLine.split(" ")
    val numH = line(0).toInt
    val numW = line(1).toInt

    if (numH != 0 && numW != 0 && numH %2 == 0 && numW %2 == 0){
        println("YES")
    } else {
        println("NO")
    }
}
