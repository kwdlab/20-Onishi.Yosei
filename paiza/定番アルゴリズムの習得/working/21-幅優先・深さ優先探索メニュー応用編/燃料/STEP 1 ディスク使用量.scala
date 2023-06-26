import scala.io.StdIn._

object Main extends App {

    val n = readLine().trim().toInt
    val line = Array.fill(n)(readLine().trim().split(" "))

    val name = line.map(_(0))
    val size = line.map(_(1).toLong)
    val num = line.map(_(2).toInt)
    val child = Array.fill(n)(List.empty[Int])

    for (i <- 0 until n; j <- 0 until num(i)) {
        child(i) = line(i)(j + 3).toInt - 1 :: child(i)
    }

    for (i <- (n - 1) to 0 by -1) {
        for (next <- child(i)) {
            size(i) += size(next)
        }
    }

    (0 until n).foreach(i => println(s"${name(i)} ${size(i)}"))
}
//解答例使用済み
//Exception in thread "main" java.lang.StackOverflowError
//再帰は無理