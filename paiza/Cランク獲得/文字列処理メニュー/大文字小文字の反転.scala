import scala.io.StdIn._

object Main extends App {

    var S = readLine().toArray

    for (i <- 0 until S.length){
        if (S(i).isUpper){
            S(i) = S(i).toLower
        } else if (S(i).isLower){
            S(i) = S(i).toUpper
        }
    }
    println(S.mkString(""))
}