import scala.io.StdIn._

object Main extends App {

    val Array(n, k, r) = readLine().trim().split(" ").map(_.toInt)
    val g = Array.ofDim[Int](2*n - 1)
    g(0) = r

    for (_ <- 1 until n){
        val line = readLine().trim().split(" ")
        val a = line(0).toInt
        val b = line(1).toInt
        val lr = line(2)

        val i = g.indexOf(a)
        if (lr == "L") g(2*i + 1) = b
        else g(2*i + 2) = b
    }

    for (_ <- 0 until k){
        val linek = readLine().trim().split(" ")
        val v = linek(0).toInt
        val lrk = linek(1)

        val j = g.indexOf(v)
        if (lrk == "L") println(g(2*j + 1))
        else println(g(2*j + 2))
    }
}
