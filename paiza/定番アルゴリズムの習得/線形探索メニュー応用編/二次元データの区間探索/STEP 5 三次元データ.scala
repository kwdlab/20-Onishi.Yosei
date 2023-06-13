import scala.io.StdIn._

object Main extends App {

    val Array(n, m, h, x) = readLine().split(" ").map(_.toInt)

    def countUp(count: Int, i: Int, j: Int): Int = {
        if (i == h){
            return count
        } else if (j == n){
            countUp(count, i+1, 0)
        } else {
            val tmp = readLine().split(" ").map(_.toInt).count(_ == x)
            countUp(count+tmp, i, j+1)
        }
    }

    val result = countUp(0, 0, 0)
    println(result)
}



    def countUp() = {
        var count = 0
        for (i <- 0 until h; j <- 0 until n){
            count = count + readLine().split(" ").map(_.toInt).count(_ == x)
        }
        println(count)
    }
    countUp()
}
