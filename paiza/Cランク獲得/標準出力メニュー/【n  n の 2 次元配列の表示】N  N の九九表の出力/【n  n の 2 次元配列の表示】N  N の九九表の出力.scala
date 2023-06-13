import scala.io.StdIn._

object Main extends App {

    val num = readLine().toInt
    val row = num
    val column = num

    for (i <- 0 until row){
        val result = Array.ofDim[String](column)
        for (j <- 0 until column){
            result(j) = s"${(i+1)*(j+1)}"
        }
        println(result.mkString(" "))
    }
}
