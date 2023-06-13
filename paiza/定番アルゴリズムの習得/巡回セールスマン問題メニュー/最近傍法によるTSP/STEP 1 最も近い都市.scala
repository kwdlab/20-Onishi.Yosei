import scala.io.StdIn._
import math._

object Main extends App {

    val n = readLine().trim().toInt
    val city = Array.ofDim[Double](n, 2)
    for (i <- 0 until n) {
        city(i) = readLine().trim().split(" ").map(_.toDouble)
    } 

    def Euclidean(a: Array[Double], b: Array[Double]):Double = {
        return sqrt(pow(a(0)-b(0), 2) + pow(a(1)-b(1), 2))
    }
    def minEuclidean(cnt: Int, min: (Double, Int), leftCity: Array[Double], rightCity: Array[Double]): Int = {
        if (cnt < n-1){
            val resEuc = Euclidean(leftCity, rightCity)
            if (resEuc < min._1){
                minEuclidean(cnt+1, (resEuc, cnt), city(0), city(cnt+1))
            } else {
                minEuclidean(cnt+1, min, city(0), city(cnt+1))
            }
        } else {
            return min._2
        }
    }
    
    val result = minEuclidean(0, (Double.MaxValue, 0), city(0), city(0+1))
    println(result)
}