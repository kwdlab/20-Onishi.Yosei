import scala.io.StdIn._

object Main extends App {

    val S = readLine().split("")
    val T = readLine().split("")
    var STsum : Array[Int] = Array.empty

    for (i <-0 until S.length){
        STsum = STsum ++ Array(S(i).toInt + T(i).toInt)
    }
    
    println(STsum.mkString(""))
}