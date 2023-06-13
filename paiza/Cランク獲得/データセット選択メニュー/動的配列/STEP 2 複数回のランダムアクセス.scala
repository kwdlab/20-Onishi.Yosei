import scala.io.StdIn._

object Main extends App {

    val n = readLine().toInt
    val a = readLine().split(" ").map(_.toInt)
    val q = readLine().toInt
    val b = readLine().split(" ").map(_.toInt)

    for (i <- 0 until q){
        println(a(b(i)-1))
    }
}
