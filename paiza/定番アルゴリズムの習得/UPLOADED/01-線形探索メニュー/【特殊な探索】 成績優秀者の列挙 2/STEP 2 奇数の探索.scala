import scala.io.StdIn._

object Main extends App {

    val n = readLine().toInt
    val an = readLine().split(" ").map(_.toInt)
    
    def searchEven(x: Array[Int], n: Int): Int = {
        for (i <- 0 until n){
            if (x(i) % 2 == 0){
                return i+1
            }
        }
        return -1    
    } 
    def searchLastOdd(x: Array[Int], n: Int): Int = {
        var tmp = 0
        for (i <- 0 until n){
            if (x(i) % 2 != 0){
                tmp = i+1
            }
        }
        return tmp    
    }
    println(searchLastOdd(an, n))
}
