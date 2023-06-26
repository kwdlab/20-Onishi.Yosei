import scala.io.StdIn._
import scala.collection.mutable.Queue
object Main extends App {

    val n = readLine().toInt
    val H = Array.fill(10)(Array.empty[Int])
    for (_ <- 0 until n) {
        val x = readLine().toInt
        val tmp = x % 10
        H(tmp) = H(tmp) ++ Array(x)
    }

    for (i <- H){
        println(i.mkString(" "))
    }
}