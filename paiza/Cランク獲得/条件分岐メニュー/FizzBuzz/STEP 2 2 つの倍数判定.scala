import scala.io.StdIn._

object Main extends App {

    val num = readLine().toInt

    if (num%3 == 0 && num%5 == 0){
        println("YES")
    } else {
        println("NO")
    }
}
