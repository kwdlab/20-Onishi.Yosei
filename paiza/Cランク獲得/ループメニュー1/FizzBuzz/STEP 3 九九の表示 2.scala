import scala.io.StdIn._

object Main extends App {

    val num = readLine().toInt
    val key = 9
    val result = Array.ofDim[String](key)

    for (i <- 0 until key){
        result(i) = s"${num*(i.toInt+1)}"
    }
    println(result.mkString(" "))
}
