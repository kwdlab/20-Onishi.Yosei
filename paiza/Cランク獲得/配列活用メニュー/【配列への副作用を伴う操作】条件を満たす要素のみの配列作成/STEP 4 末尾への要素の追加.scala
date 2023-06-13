import scala.io.StdIn._

object Main extends App {

    val n = readLine().trim().toInt
    val a = Array.fill(n)(readLine().trim().toInt)
    
    val b = readLine().toInt
    val newA = a :+ b

    newA.foreach(println)
}