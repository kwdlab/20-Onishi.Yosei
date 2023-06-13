import scala.io.StdIn._

object Main extends App {

    val a = readLine()
    val S = readLine() 
    
    if(S.contains(a)){
        println("YES")
    } else {
        println("NO")
    }
}
