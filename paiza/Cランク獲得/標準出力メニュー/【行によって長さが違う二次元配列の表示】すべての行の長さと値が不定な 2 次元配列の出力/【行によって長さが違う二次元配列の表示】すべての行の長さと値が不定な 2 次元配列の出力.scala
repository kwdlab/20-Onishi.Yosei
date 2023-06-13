import scala.io.StdIn._

object Main extends App {

    val Array(n, m) = readLine().split(" ").map(_.toInt)

    val a = readLine().trim().split(" ").map(_.toInt)
    val b = readLine().trim().split(" ").map(_.toInt)
    
    def loop(cnt: Int, a: Array[Int]): Unit = {
        if (cnt == m){
            return
        } else {
            println(a.take(b(cnt)).mkString(" "))
            loop(cnt+1, a.drop(b(cnt)))
        }
    }
    loop(0, a)
}