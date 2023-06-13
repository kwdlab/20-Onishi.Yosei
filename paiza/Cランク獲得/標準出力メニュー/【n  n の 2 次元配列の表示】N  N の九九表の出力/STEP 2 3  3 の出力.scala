import scala.io.StdIn._

object Main extends App {

    val line = readLine().split(" ")
    val row = 3
    val column = 3

    for (i <- 0 until row){
        val result = Array.ofDim[String](column)
        for (j <- 0 until column){
            result(j) = line(i*column+j)
        }
        println(result.mkString(" "))
    }
}
