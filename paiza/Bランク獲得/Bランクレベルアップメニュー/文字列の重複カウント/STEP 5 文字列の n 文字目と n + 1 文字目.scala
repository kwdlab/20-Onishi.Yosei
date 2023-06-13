import scala.io.StdIn._

object Main extends App {

    val n = readLine().toInt
    val s = readLine().split("")
    
    if (n < s.length){
        println(s(n-1) +" "+ s(n))
    }
}
