import scala.io.StdIn._
import scala.collection.mutable.Queue

object Main extends App {

    val Array(n, x) = readLine().split(" ").map(_.toInt)
    val An = readLine().split(" ").map(_.toInt)

    var left_num = An(0)
    var max_sum = 0 
    for (i <- 0 until x) {
        max_sum = max_sum + An(i)
    }
    var tmp_sum = max_sum

    for (i <- 0 until (n-x)) {
        tmp_sum = tmp_sum - An(i)
        tmp_sum = tmp_sum + An(i+x)
        if (tmp_sum > max_sum) {
            left_num = An(i+1)
            max_sum = tmp_sum
        }
    }

    println(s"$max_sum $left_num")
}
//解答例使用済み