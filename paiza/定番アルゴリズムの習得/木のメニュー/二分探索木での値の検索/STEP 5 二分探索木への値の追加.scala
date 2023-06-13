import scala.io.StdIn._
import scala.collection.mutable.Map

object Main extends App {

    val location: Map[Int, Int] = Map.empty
    val g: Array[Int] = Array.fill(1000000)(-1)
    
    val Array(n, r) = readLine().trim().split(" ").map(_.toInt)
    location.put(r, 0)
    g(0) = r

    for (_ <- 1 until n) {
        val line = readLine().trim().split(" ")
        val a = line(0).toInt
        val b = line(1).toInt
        val lr = line(2)
        val index = {
            if (lr == "L"){
                2 * location(a) + 1 
            }else{
                2 * location(a) + 2 
            }
        }
        location.put(b, index)
        g(index) = b
    }

    val v = readLine().trim().toInt
    var now = 0
    while (g(now) != -1) {
        now = {
            if (v < g(now)){
                2 * now + 1 
            } 
            else{
                2 * now + 2
            } 
        }
    }
    println(g((now - 1) / 2))
    if (now % 2 == 0){
        println("R")
    }  
    else{
        println("L")
    } 

}
//解答例使用済み