import scala.io.StdIn._

object Main extends App {

    val Array(h, w, r, c)= readLine().split(" ").map(_.toInt)
    val s = Array.fill(h)(readLine().split(""))
    
    if (s(r-1)(c-1) == "#") {
        println("Yes")
    } else {
        println("No")
    }
}
