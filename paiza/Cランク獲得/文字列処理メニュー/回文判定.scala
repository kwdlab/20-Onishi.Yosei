import scala.io.StdIn._

object Main extends App {

    val S = readLine()

    if (S == S.reverse){
        println("YES")
    } else {
        println("NO")
    }
}