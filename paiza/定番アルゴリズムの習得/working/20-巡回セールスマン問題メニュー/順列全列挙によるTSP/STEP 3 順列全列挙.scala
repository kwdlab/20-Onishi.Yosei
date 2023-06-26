import scala.io.StdIn._

object Main extends App {

    val n = readLine().trim().toInt
    for (i <- (1 to n).permutations){
        println(i.mkString(" "))
    }
}