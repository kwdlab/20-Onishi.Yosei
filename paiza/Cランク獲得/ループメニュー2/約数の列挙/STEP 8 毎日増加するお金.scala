import scala.io.StdIn._

object Main extends App {

    val Array(a, b) = readLine().trim().split(" ").map(_.toDouble)

    def test(cnt: Int, a: Double): Unit = {
        if (a > b){
            println(cnt)
            return 
        } else {
            test(cnt+1, (a*1.1).floor)
        }
    }
    test(0, a)
}
