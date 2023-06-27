import scala.io.StdIn._
import scala.collection.mutable.HashMap

object Main extends App {

    val n1 = readLine().toInt
    val graph1 = Array.fill(n1)(List.empty[Int])
    for (_ <- 0 until n1 - 1) {
        val Array(a, b) = readLine().split(" ").map(_.toInt - 1)
        graph1(a) = b :: graph1(a)
        graph1(b) = a :: graph1(b)
    }
    val n2 = readLine().toInt
    val graph2 = Array.fill(n2)(List.empty[Int])
    for (_ <- 0 until n2 - 1) {
        val Array(a, b) = readLine().split(" ").map(_.toInt - 1)
        graph2(a) = b :: graph2(a)
        graph2(b) = a :: graph2(b)
    }

    if (n1 != n2) println("NO")
    else {
        val d = HashMap.empty[Int, Int]
        val permutation = (0 until n1).toList.permutations
        var check = false

        while (permutation.hasNext && !check) {
            val p = permutation.next()
            d.clear()
            for (i <- 0 until n1) {
                d(p(i)) = i
            }
            check = true
            for (i <- 0 until n1) {
                if (graph1(i).length != graph2(d(i)).length) check = false
            }
        }

        if (check) println("YES")
        else println("NO")
    }
}
//解答例使用済み