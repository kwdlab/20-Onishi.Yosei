import scala.io.StdIn._

object Main extends App {

    val n = readLine().trim().toInt
    val a = Array.fill(n)(readLine().trim().toInt)
    
    if(a.count(_ == 7) > 0) {
        println("YES")
    } else {
        println("NO")
    }
}
