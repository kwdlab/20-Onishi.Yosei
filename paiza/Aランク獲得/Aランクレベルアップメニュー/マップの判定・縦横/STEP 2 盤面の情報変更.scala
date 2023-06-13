import scala.io.StdIn._

object Main extends App {
    
    val HWN = readLine().split(" ").map(_.toInt)
    val H = HWN(0)
    val W = HWN(1)
    val N = HWN(2)
    val Sh = Array.ofDim[String](H, W)

    for(i <- 0 until H){
        Sh(i) = readLine().split("")
    }
    for(i <- 0 until N){
        val yx = readLine().split(" ").map(_.toInt)
        change(yx(0), yx(1))
    }

    def change(y: Int, x: Int) : Unit = {
        if (Sh(y)(x) == "."){ Sh(y)(x) = "#" }
    }

    for(i <- Sh){
        println(i.mkString(""))
    }
}
