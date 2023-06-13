import scala.io.StdIn._

object Main extends App {

    val num = readLine().toInt
    val Aline = readLine().split(" ")
    var tmp = 1000

    for (i <- 0 until num){
        if ((Aline(i).toInt + i + 1) < tmp){
            tmp  = (Aline(i).toInt + i + 1)
        }
    }
    println(tmp)
}
