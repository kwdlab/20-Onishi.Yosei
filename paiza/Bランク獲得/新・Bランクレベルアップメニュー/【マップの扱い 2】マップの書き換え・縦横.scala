import scala.io.StdIn._

object Main extends App {

    val HW = readLine().split(" ").map(_.toInt)
    val H = HW(0)
    val W = HW(1)
    val stage = Array.ofDim[String](H, W)

    for (i <- 0 until H){
        val line = readLine().split("")
        stage(i) = line
    }

    val yx = readLine().split(" ").map(_.toInt)
    val y = yx(0)
    val x = yx(1)

    val spot = Array(Array(y-1, x), Array(y, x-1), Array(y, x), Array(y, x+1), Array(y+1, x))
    for (i <- spot){
        if (0 <= i(0) && i(0) < H && 0 <= i(1) && i(1) < W){
            if (stage(i(0))(i(1)) == "."){
                stage(i(0))(i(1)) = "#"
            } else {
                stage(i(0))(i(1)) = "."
            } 
        }
    }

    for (i <- stage){
        println(i.mkString(""))
    }
}