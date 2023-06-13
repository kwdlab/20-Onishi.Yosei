import scala.io.StdIn._

object Main extends App {

    val num = readLine().split(" ")
    val numA = num(0).toInt
    val numB = num(1).toInt
    val numC = num(2).toInt

    if (numA*numB <= numC){
        println("YES")
    } else {
        println("NO")  
    }
}
