import scala.io.StdIn._

object Main extends App {

    val N = readLine().toInt
    val Aline = readLine().split(" ").map(_.toInt)
    
    for (i <- 0 until N-1){
        val cutL = Aline.take(i+1)
        if (cutL.contains(Aline(i+1))){
            println("Yes")
        } else {
            println("No")
        }
    }
}
