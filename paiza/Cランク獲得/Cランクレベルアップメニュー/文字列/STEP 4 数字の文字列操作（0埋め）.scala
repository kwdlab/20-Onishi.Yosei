import scala.io.StdIn._

object Main extends App {

    val n = readLine()

    if (n.length == 1){
        println(s"00${n}")
    }else if (n.length == 2){
        println(s"0${n}")
    }else if (n.length == 3){
        println(s"${n}")
    }
}