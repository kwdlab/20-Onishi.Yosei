import scala.io.StdIn._

object Main extends App {

    val NM = readLine().split(" ").map(_.toInt)
    val N = NM(0)
    val M = NM(1)
    val g = Array.ofDim[Int](N, N)

    for (i <- 0 until M){
        val ab = readLine().split(" ").map(_.toInt)
        val a = ab(0) - 1
        val b = ab(1) - 1
        g(a)(b) = 1
        g(b)(a) = 1
    }

    for (i <- g){
        println(i.mkString(""))
    }
}

//解答例使用済み