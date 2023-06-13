import scala.io.StdIn._

object Main extends App {

    val n = readLine().toInt

    val result = (2 to n).count { i =>
        val number = (1 to n).count(j => i % j == 0)
        number == 2
    }

    println(result)
}