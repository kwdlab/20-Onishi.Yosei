import scala.io.StdIn._

object Main extends App {

    val a = Array(1, 5, 9, 7, 5, 3, 2, 5, 8, 4)
    val n = a.length
    val l = 2
    val r = 7
    val s = Array.ofDim[Int](n+1)

    for (i <- 0 until n+1){
        if (i == 0){
            s(i) = 0
        } else {
            s(i) = a(i-1) + s(i-1)
        }
    }

    println(s(r+1)-s(l))
}
//累積和