import scala.io.StdIn._
import scala.collection.mutable.Queue

object Main extends App {

    val Array(n, x) = readLine().split(" ").map(_.toInt)
    val an = readLine().split(" ").map(_.toInt)

    var leftNum = an(0)
    var maxSum = an.take(x).sum
    var tmpSum = maxSum
    for (i <- 0 until (n-x)) {
        tmpSum -= an(i)
        tmpSum += an(i+x)

        if (tmpSum > maxSum) {
            leftNum = an(i+1)
            maxSum = tmpSum
        }
    }

    println(s"$maxSum $leftNum")
}
//解答例使用済み