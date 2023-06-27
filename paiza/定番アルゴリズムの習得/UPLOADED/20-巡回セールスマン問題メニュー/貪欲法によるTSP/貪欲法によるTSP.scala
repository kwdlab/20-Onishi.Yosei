import scala.io.StdIn._
import scala.collection.mutable.ArrayBuffer
import scala.math._

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

    def Euclidean(a: Array[Double], b: Array[Double]): Double = {
        sqrt(pow(a(0) - b(0), 2) + pow(a(1) - b(1), 2))
    }

    def scan(n: Int, edges: Array[ArrayBuffer[Int]]): Array[Int] = {
        var start = -1
        for (i <- 0 until n) {
            if (edges(i).length == 1) {
                start = i
            }
        }
        val tour = new ArrayBuffer[Int](n)
        tour.append(start)
        tour.append(edges(start)(0))
        for (_ <- 2 until n) {
            val prev = tour(tour.length - 2)
            val curr = tour(tour.length - 1)
            for (next <- edges(curr)) {
                if (next != prev) {
                    tour.append(next)
                }
            }
        }
        tour.toArray
    }

    val n = readLine().trim().toInt
    val points = Array.ofDim[Double](n, 2)
    for (i <- 0 until n) {
        points(i) = readLine().trim().split(" ").map(_.toDouble)
    }

    val edges = new ArrayBuffer[(Double, Int, Int)]()
    for (i <- 0 until n; j <- i + 1 until n) {
        val d = Euclidean(points(i), points(j))
        edges.append((d, i, j))
    }
    val sortEdges = edges.sortBy(_._1)

    val uf = new UnionFind(n)
    val tourEdges = Array.fill(n)(new ArrayBuffer[Int](2))

    for ((d, i, j) <- sortEdges) {
        if (uf.same(i, j) || tourEdges(i).length == 2 || tourEdges(j).length == 2) {

        } else {
            tourEdges(i).append(j)
            tourEdges(j).append(i)
            uf.unite(i, j)
        }
    }

    val tour = scan(n, tourEdges)
    tour.foreach(println)
}

//解答例使用済み
