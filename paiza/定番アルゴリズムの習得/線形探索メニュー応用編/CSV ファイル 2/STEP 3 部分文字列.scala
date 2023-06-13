import scala.io.StdIn._

object Main extends App {

    val s = readLine().split("")
    val t = readLine().split("")
    
    val line = s.sliding(t.length).toList
    println(line.count(_.sameElements(t)))
}
