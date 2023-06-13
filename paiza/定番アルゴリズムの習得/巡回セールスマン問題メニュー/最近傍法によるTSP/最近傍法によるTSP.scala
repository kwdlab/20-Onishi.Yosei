import scala.io.StdIn._
import math._

object Main extends App {

    val n = readLine().trim().toInt
    val cityGlobal = Array.ofDim[Double](n, 2)
    val start = 0
    val reset = (Double.MaxValue, -1)
    for (i <- 0 until n) {
        cityGlobal(i) = readLine().trim().split(" ").map(_.toDouble)
    } 

    def Euclidean(a: Array[Double], b: Array[Double]):Double = {
        return sqrt(pow(a(0)-b(0), 2) + pow(a(1)-b(1), 2))
    }
    def pathSearch(min: (Double, Int), city: Array[Array[Double]], left: Int, right: Int):Unit = {
        if (city.length < 2){
            return
        } else if (right < city.length){
            val resEuc = Euclidean(city(left), city(right))
            if (resEuc < min._1 && resEuc != 0){
                pathSearch((resEuc, right), city, left, right+1)
            } else {
                pathSearch(min, city, left, right+1)
            }
        } else {
            println(cityGlobal.indexOf(city(min._2)))
            val newCity = city.filterNot(_.sameElements(city(left)))
            pathSearch(reset, newCity, newCity.indexOf(city(min._2)), 0)
        }
    }

    println(start)
    pathSearch(reset, cityGlobal, start, 0)
}