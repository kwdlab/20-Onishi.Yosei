import scala.io.StdIn._

object Main extends App {

    val Array(a, b, c) = readLine().split(" ").map(_.toLong)
    
    if (a%b == c){
        println(s"${1} ${-(a/b)}")
    } else {
        println(s"${-(b/a)} ${1}")
    }
}