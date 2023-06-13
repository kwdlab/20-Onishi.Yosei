import scala.io.StdIn._

object Main extends App {

    val numN = readLine().toInt
    val lineA = readLine.split(" ")
    var result = 0
    var flag = 0

    for (i <- 0 until numN){
        if (lineA(i).toInt%2 == 0 && flag == 0){
            result = result + lineA(i).toInt
        } else {
            flag = 1
        }
    }
    println(result)
}
