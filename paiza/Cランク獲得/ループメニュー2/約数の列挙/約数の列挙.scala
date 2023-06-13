import scala.io.StdIn._

object Main extends App {

    val num = readLine().toInt

    for (i <- 1 to num){
        if (num % i == 0){
            println(i)
        }
    }
}
