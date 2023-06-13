import scala.io.StdIn._

object Main extends App {

    val n = readLine().trim().toInt
    val a = Array.fill(n)(readLine().trim().toInt)
    
    val b = readLine().trim().toInt
    val newA = a.take(b-1) ++ a.drop(b)

    newA.foreach(println)
}