import scala.io.StdIn._

object Main extends App {

    val num = readLine().toInt

    if (num%3 == 0 && num%5 == 0){
        println("FizzBuzz")
    } else if (num%3 == 0){
        println("Fizz")
    } else if (num%5 == 0){
        println("Buzz")
    } else {
        println(s"${num}")
    }
}
