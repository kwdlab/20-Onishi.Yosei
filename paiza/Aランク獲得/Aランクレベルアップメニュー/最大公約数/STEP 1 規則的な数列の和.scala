import scala.io.StdIn._

object Main extends App {

    val NK = readLine().split(" ").map(_.toLong)
    val N = NK(0)
    val K = NK(1)

    if (N%3 == 1){
        if (K%3 == 0){
            println(0)
        }
        else {
            println(1)
        }
    } else if (N%3 == 2){
        if (K%3 == 0){
            println(-1)
        }
        else {
            println(0)
        }
    } else {
        if (K%3 == 0){
            println(-1)
        }
        else {
            println(0)
        }
    }
}

//解答例使用済み