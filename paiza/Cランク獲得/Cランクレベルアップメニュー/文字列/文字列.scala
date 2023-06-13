import scala.io.StdIn._

object Main extends App {

    val n = readLine().toInt
    val tmp = Array.fill(n)(readLine().split(" "))
    val tL = tmp.map(_(0).split(":").map(_.toInt))
    val hL = tmp.map(_(1).toInt)
    val mL = tmp.map(_(2).toInt)

    for (i <- 0 until n){
        tL(i)(0) = tL(i)(0) + hL(i)
        tL(i)(1) = tL(i)(1) + mL(i)

        if(tL(i)(1) >= 60){
            tL(i)(1) = tL(i)(1) - 60
            tL(i)(0) = tL(i)(0) + 1
        }
        if(tL(i)(0) >= 24){
            tL(i)(0) = tL(i)(0) - 24
        }
    
        val result = String.format("%2s", tL(i)(0)).replace(" ", "0") + ":" + String.format("%2s", tL(i)(1)).replace(" ", "0")
        println(result)
    }
}