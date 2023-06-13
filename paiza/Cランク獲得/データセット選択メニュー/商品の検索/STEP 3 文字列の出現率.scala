import scala.io.StdIn._

object Main extends App {

    val n = readLine().toInt
    val s = Array.fill(n)(readLine().trim())
    val list = s.distinct.sorted

    for (i <- list){
        println(s"${i} ${s.count(x => x == i)}")
    }
}
