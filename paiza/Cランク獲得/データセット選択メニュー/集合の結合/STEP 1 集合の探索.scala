import scala.io.StdIn._

object Main extends App {

    val line = readLine().split(" ")
    val N = line(0).toInt
    val B = line(1).toInt
    val Aline = readLine().split(" ").map(_.toInt)
    
    if (Aline.contains(B)){
        println("Yes")
    } else {
        println("No")
    }
}
