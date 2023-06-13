import scala.io.StdIn._

object Main extends App {

    val HW = readLine().split(" ").map(_.toInt)
    val H = HW(0)
    val W = HW(1)
    val point = HW.max
    val stage = Array.ofDim[String](H, W)
    val spot = Array.ofDim[Array[Int]](point*2, 4)

    for (i <- 0 until H){
        val line = readLine().split("")
        stage(i) = line
    }

    val yx = readLine().split(" ").map(_.toInt)
    val y = yx(0)
    val x = yx(1)

    for (a <- 1 until point){
        val cross = Array(Array(y+a, x+a), Array(y+a, x-a), Array(y-a, x-a), Array(y-a, x+a))
        spot(a-1) =  cross
    }
    for (a <- 1 until point){
        val verhol = Array(Array(y+a, x), Array(y-a, x), Array(y, x+a), Array(y, x-a))
        spot(a-1+point) =  verhol
    }
    spot(2*point-1) = Array(Array(y, x))

    for (j <- spot){
        for (i <- j){
            if (i != null && 0 <= i(0) && i(0) < H && 0 <= i(1) && i(1) < W){
                if (stage(i(0))(i(1)) == "."){
                    stage(i(0))(i(1)) = "#"
                } else {
                    stage(i(0))(i(1)) = "."
                } 
            }
        }
    }

    for (i <- stage){
        println(i.mkString(""))
    }
}