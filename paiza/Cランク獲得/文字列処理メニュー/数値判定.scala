import scala.io.StdIn._

object Main extends App {

    val S = readLine()
    var flag = 0

    for (i <- 0 until S.length){
        if (!(S(i).isDigit)){
            flag = 1
        }
    }
    if (flag == 0){
        println("YES")
    } else {
        println("NO")
    }
}