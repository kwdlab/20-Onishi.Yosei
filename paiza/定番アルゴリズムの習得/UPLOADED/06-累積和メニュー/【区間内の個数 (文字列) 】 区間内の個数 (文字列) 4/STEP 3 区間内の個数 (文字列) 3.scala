import scala.io.StdIn._

object Main extends App {

    val Array(l, r) = readLine().split(" ").map(_.toInt - 1)
    val tmp = readLine().split("")
    val a = tmp.map(x => if(x == "b"){ 1 } else { 0 })
    val n = a.length
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