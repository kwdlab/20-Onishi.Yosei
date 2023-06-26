import scala.io.StdIn._
import math._

object Main extends App {

    val n = readLine().trim().toInt
    val city = Array.ofDim[Double](n, 2)
    for (i <- 0 until n) {
        city(i) = readLine().trim().split(" ").map(_.toDouble)
    } 
    val p = (1 to n).toArray.map(_ - 1).permutations.toArray

    def Euclidean(a: Array[Double], b: Array[Double]):Double = {
        val resEuc = sqrt(pow(a(0)-b(0), 2) + pow(a(1)-b(1), 2))
        return resEuc
    }
    def sumEuclidean(cnt: Int, sum: Double, leftCity: Array[Double], q: Array[Int]): Double = {
        if (cnt < n-1){
            val rightCity = city(q(cnt+1))
            val resEuc = Euclidean(leftCity, rightCity)
            sumEuclidean(cnt+1, sum+resEuc, rightCity, q)
        } else {
            return sum + Euclidean(leftCity, city(q(0)))
        }
    }
    def allPathSeach(path: Array[Array[Int]], minEuc: Double, minPath: Array[Int]):Unit = {
        if (path.nonEmpty){
            val current = path.head
            val tmp = sumEuclidean(0, 0.0, city(current(0)), current)
            if (tmp < minEuc){
                allPathSeach(path.drop(1), tmp, current)
            } else {
                allPathSeach(path.drop(1), minEuc, minPath)
            }
        } else {
            println(minEuc)
            println(minPath.map(_ + 1).mkString(" "))
        }
    }
       
    allPathSeach(p, Double.MaxValue, Array(0))
}