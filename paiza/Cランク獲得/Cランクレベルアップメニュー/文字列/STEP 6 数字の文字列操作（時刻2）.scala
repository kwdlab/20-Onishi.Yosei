import scala.io.StdIn._

object Main extends App {

    val s = readLine().split(":").map(_.toInt)
    val (resH, resM) = {
        if (s(1) < 30){
            (s(0), s(1)+30)
        } else {
            (s(0)+1, s(1)-30)
        }
    }

    val result = String.format("%2s", resH).replace(" ", "0") + ":" + String.format("%2s", resM).replace(" ", "0")
    println(result)
}