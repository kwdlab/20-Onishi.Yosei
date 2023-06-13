import scala.io.StdIn._

object Main extends App {

    val Array(n, q) = readLine().split(" ").map(_.toInt)
    val s = Array.fill(n)(readLine().trim())
    val t = Array.fill(q)(readLine().trim())

    for (i <- t){
        if (s.contains(i)){
            println(s.indexOf(i)+1)
        } else {
            println(-1)
        }
    }
}
