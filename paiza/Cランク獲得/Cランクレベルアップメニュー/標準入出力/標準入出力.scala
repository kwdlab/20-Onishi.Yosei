import scala.io.StdIn._

object Main extends App {

    val n = readLine().toInt 
    val s = Array.fill(n)(readLine().trim().split(" "))

    for (i <- s){
        println(s"${i(0)} ${i(1).toInt+1}")
    }
}
