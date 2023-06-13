import scala.io.StdIn._

object Main extends App {
     
    val Array(n, k) = readLine().trim().split(" ").map(_.toInt)
    val sn = Array.fill(n)(readLine().trim())
    val yck = Array.ofDim[String](k)

    def padding(x: String) : String = {
        val tmp = String.format("%10s", x).replace(" ", "0")
        return tmp
    }

    for (i <- 0 until k){
        val Array(y, c) = readLine().trim().split(" ")
        yck(i) = padding(y) + c
    }

    for (i <- yck.sorted; j <- sn){
        if (i.contains(j)){
            println(j)
        }
    }
}