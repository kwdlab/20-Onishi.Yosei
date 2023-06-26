import scala.io.StdIn._

object Main extends App {

    class UnionFind(var n: Int) {
        val parent: Array[Int] = Array.tabulate(n)(identity)

        def getParent(a: Int): Int = {
        if (a != parent(a)) {
            parent(a) = getParent(parent(a))
        }
        parent(a)
    }
    def unite(a: Int, b: Int): Unit = {
        val parentA = getParent(a)
        val parentB = getParent(b)
        parent(parentB) = parentA
    }
    def same(a: Int, b: Int): Boolean = {
        getParent(a) == getParent(b)
    }
    }

    val Array(n, m) = readLine().trim().split(" ").map(_.toInt)

    val uf = new UnionFind(n)
    val degrees = Array.fill(n)(0)
    for (_ <- 0 until m) {
        val Array(a, b) = readLine().trim().split(" ").map(_.toInt)
        uf.unite(a, b)
        degrees(a) += 1
        degrees(b) += 1
    }

    val Array(ea, eb) = readLine().split(" ").map(_.toInt)
    degrees(ea) += 1
    degrees(eb) += 1
    val degrees_lte2 = degrees(ea) <= 2 && degrees(eb) <= 2
    val contains_cycle = uf.same(ea, eb)

    if (degrees_lte2 && !contains_cycle) {
        println("Yes")
    } else {
        println("No")
    }
}
//解答例使用済み