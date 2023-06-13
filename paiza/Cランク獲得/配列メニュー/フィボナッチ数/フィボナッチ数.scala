import scala.io.StdIn._

object Main extends App {

    val num = readLine().toInt    

    def Fib(x: Int): Int = {
        if (x == 0){
            0
        } else if (x == 1) {
            1
        } else {
            Fib(x-2) + Fib(x-1)
        }
    }

    for (i <- 0 until num){
        println(Fib(i))
    }
}
