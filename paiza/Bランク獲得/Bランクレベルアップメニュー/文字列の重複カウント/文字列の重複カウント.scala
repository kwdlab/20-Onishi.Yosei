import scala.io.StdIn._

object Main extends App {

    val s = readLine()
    val t = readLine()
    val len = t.length - s.length + 1
    if (len > 0){
        val cutL = Array.ofDim[String](len)
        for (i <- 0 until len){
            cutL(i) = t.drop(i).take(s.length)
        }
        val result = cutL.count(x => x == s)
        println(result)
    } else {
        println(0)
    }
}
