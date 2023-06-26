import scala.io.StdIn._

object Main extends App {

    def findKString(k: Int): String = {
        val combinations = for {
            c1 <- 'a' to 'z'
            c2 <- 'a' to 'z'
            c3 <- 'a' to 'z'
        } yield s"$c1$c2$c3"

        combinations(k - 1)
    }

    val k = readLine().toInt
    println(findKString(k))
}