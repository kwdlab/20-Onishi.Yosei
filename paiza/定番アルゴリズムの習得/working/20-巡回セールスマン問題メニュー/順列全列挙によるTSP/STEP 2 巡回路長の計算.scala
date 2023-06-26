import scala.io.StdIn._
import math._

object Main extends App {

    val n = readLine().trim().toInt
    val city = Array.ofDim[Double](n, 2)
    for (i <- 0 until n) {
        city(i) = readLine().trim().split(" ").map(_.toDouble)
    } 
    val p = readLine().trim().split(" ").map(_.toInt - 1)

    def Euclidean(a: Array[Double], b: Array[Double]):Double = {
        val resEuc = sqrt(pow(a(0)-b(0), 2) + pow(a(1)-b(1), 2))
        return resEuc
    }
    def sumEuclidean(cnt: Int, sum: Double, leftCity: Array[Double]): Double = {
        if (cnt < n-1){
            val rightCity = city(p(cnt+1))
            val resEuc = Euclidean(leftCity, rightCity)
            sumEuclidean(cnt+1, sum+resEuc, rightCity)
        } else {
            return sum + Euclidean(leftCity, city(p(0)))
        }
    }
    
    val result = sumEuclidean(0, 0.0, city(p(0)))
    println(result)
}