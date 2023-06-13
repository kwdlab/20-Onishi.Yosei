import scala.io.StdIn._

object Main extends App {

    def findKString(k: Int): String = {
        val combinations = for {
            c1 <- 'a' to 'z'
            c2 <- 'a' to 'z'
            c3 <- 'a' to 'z'
        } yield s"$c1$c2$c3"

        combinations.lift(k - 1).getOrElse("")
    }

    val k = readLine().toInt
    val result = findKString(k)
    println(result)
}
//解答例使用済み