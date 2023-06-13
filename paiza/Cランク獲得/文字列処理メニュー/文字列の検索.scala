import scala.io.StdIn._

object Main extends App {

    val S = readLine()
    val T = readLine()
    
    if (S.contains(T)){
        println("YES")
    } else {
        println("NO")
    }
}