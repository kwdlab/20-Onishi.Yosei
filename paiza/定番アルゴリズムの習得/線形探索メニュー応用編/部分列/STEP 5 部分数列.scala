import scala.io.StdIn._

object Main extends App {

    val Array(n, m) = readLine().split(" ").map(_.toInt)
    val an = readLine().split(" ").map(_.toInt)
    val bm = readLine().split(" ").map(_.toInt)

    def printOut(): Unit = {
        var count = 0
        for (i <- an.sliding(m).toList){
            count = count + 1
            if (bm.sameElements(i)){
                println(count)
                return
            }
        }
        println(-1)
    }
    printOut()
}
