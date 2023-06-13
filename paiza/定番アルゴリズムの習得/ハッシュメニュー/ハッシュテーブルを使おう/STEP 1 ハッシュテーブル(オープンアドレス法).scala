import scala.io.StdIn._

object Main extends App {

    val n = readLine().toInt
    val H = Array.fill(10)(-1)

    for (_ <- 0 until n) {
        val x = readLine().toInt
        if (H(x % 10) == -1){
            H(x % 10) = x
        } else {
            def inner(cnt: Int): Unit = {
                val retmp = (x+cnt+1) % 10
                if (H(retmp) == -1){
                    H(retmp) = x
                    return
                }
                inner(cnt+1)
            }
            inner(0)
        }
    }
    H.foreach(println)
}