import scala.io.StdIn._

object Main extends App {

    val Array(n, m, k) = readLine().trim().split(" ").map(_.toInt)

    def test(cnt: Int, n: Int): Unit = {
        if (n > k){
            println(cnt)
            return 
        } else {
            test(cnt+1, n+m)
        }
    }
    test(0, n)
}
