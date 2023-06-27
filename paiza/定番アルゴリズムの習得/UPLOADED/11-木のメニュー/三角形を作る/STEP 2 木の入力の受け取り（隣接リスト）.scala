import scala.io.StdIn._

object Main extends App {

    val n = readLine().toInt
    val matrix = Array.fill(n)(List.empty[Int])
    for (_ <- 0 until n - 1) {
        val Array(a, b) = readLine().split(" ").map(_.toInt - 1)
        matrix(a) = b+1 :: matrix(a)
        matrix(b) = a+1 :: matrix(b)
    }

    for (i <- matrix){
        println(i.toList.sorted.mkString(" "))
    }
}