import scala.io.StdIn._

object Main extends App {
    
    val HW = readLine().split(" ").map(_.toInt)
    val H = HW(0)
    val W = HW(1)
    val Sh = Array.ofDim[String](H, W)

    for(i <- 0 until H){
        Sh(i) = readLine().split("")
    }

    def TrueFalse(y: Int, x: Int) : Boolean = {
        if (Sh(y)(x) == "#"){ true }
        else { false }
    }

    for (i <- 0 until H; j <- 0 until W){
        if (TrueFalse(i, j)){ println(s"${i} ${j}") }
    }
}
