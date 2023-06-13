import scala.io.StdIn._

object Main extends App {

    val Array(n, l, r) = readLine().split(" ").map(_.toInt)
    val tmp = readLine().split("")
    val a = tmp.map(x => if(x == "b"){ 1 } else { 0 })
    val s = Array.ofDim[Int](n+1)

    for (i <- 0 until n+1){
        if (i == 0){
            s(i) = 0
        } else {
            s(i) = a(i-1) + s(i-1)
        }
    }

    println(s(r-1+1)-s(l-1))
}