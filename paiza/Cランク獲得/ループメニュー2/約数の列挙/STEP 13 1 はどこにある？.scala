import scala.io.StdIn._

object Main extends App {

    val num = readLine().toInt
    val Aline = readLine().split(" ")

    for (i <- 0 until num){
        if (Aline(i) == "1"){
            println(i+1)
        }
    }
}
