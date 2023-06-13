import scala.io.StdIn._

object Main extends App {

    val Array(m1, m2, b1, b2) = readLine().split(" ").map(_.toLong)

    def findZ(m1: Long, m2: Long, b1: Long, b2: Long): Long = {
        for (i <- 0 until m2.toInt){
            val Z = (m1*i + b1).toLong
            if (Z % m2 == b2){
                return Z
            }
        }
        return 0
    }

    val result = findZ(m1, m2, b1, b2)
    println(result)
}