import scala.io.StdIn._

object Main extends App {

    val HW = readLine().split(" ").map(_.toInt)
    val H = HW(0)
    val W = HW(1)
    val stage = Array.ofDim[String](H, W)
    val newStage = Array.ofDim[String](H, W)

    for (i <- 0 until H){
        val line = readLine().split("")
        stage(i) = line
    }

    val yx = readLine().split(" ").map(_.toInt)
    val y = yx(0)
    val x = yx(1)

    for (i <- 0 until H){
        for (j <- 0 until W){
            newStage(i)(j) = stage(i)(j)
            if (i == y && j == x){
                if (stage(i)(j) == "."){
                    newStage(i)(j) = "#"
                } else {
                    newStage(i)(j) = "."
                }
            }
        }
    }

    for (i <- newStage){
        println(i.mkString(""))
    }
}