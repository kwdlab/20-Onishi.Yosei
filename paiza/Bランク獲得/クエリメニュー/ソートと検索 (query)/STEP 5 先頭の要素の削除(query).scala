import scala.io.StdIn._

object Main extends App {
     
    val Array(n, k) = readLine().split(" ").map(_.toInt)
    val a = Array.fill(n)(readLine().trim().toInt)
    val s = Array.fill(k)(readLine().trim())

    def loop(cnt: Int, a: Array[Int]): Unit = {
        if (cnt == s.length){
            return 
        } else if (s(cnt) == "pop") {
            loop(cnt+1, a.drop(1))
        } else {
            a.foreach(println)
            loop(cnt+1, a)
        }
    }
    loop(0, a)
}
