import scala.io.StdIn._

object Main extends App {

    val Array(n, a) = readLine().split(" ").map(_.toInt)
    
    for (i <- 1 to 100000){
        if (a % n == i % n){
            println(i)
        }
    }
}
