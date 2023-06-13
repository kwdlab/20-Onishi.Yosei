import scala.io.StdIn._

object Main extends App {

    val m = readLine().trim().toInt
    val c = Array.fill(m)(readLine().trim())  
    val n = readLine().trim().toInt
    val s = Array.fill(n)(readLine().trim())

    for (i <- c; j <- s){
        if (j.contains(i)){
            println("YES")
        } else {
            println("NO")
        }
    }
}
