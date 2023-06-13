import scala.io.StdIn._

object Main extends App {

    val line = readLine().split(" ")
    val X = line(0).toInt
    val Y = line(1).toInt
    val Z = line(2).toInt

    val count: Seq[Int] = for {
        x <- 0 to 3000
        y <- 0 to 3000
        if x * X + y * Y <= Z
    } yield Z - (x * X + y * Y) + x + y

    println(count.min)
}