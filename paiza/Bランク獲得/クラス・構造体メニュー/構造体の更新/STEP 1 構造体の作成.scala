import scala.io.StdIn._

object Main extends App {
   
    val n = readLine().toInt

    for(i <- 0 until n){
        val line = readLine().split(" ")
        println("User{")
        println(s"nickname : ${line(0)}")
        println(s"old : ${line(1)}")
        println(s"birth : ${line(2)}")
        println(s"state : ${line(3)}")
        println("}")
    }
}
