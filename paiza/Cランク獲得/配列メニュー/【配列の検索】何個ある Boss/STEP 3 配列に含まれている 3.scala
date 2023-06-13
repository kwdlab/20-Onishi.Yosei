import scala.io.StdIn._

object Main extends App {

    val line = readLine().split(" ")
    val numM = line(1)
    val lineA = readLine().split(" ")

    if (lineA.contains(numM)){
        println("Yes")
    } else {
        println("No")
    }
}
