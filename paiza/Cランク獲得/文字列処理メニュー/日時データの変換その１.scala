import scala.io.StdIn._

object Main extends App {

    val timeL = readLine().split(Array('/', ':'))

    for (i <- timeL){
        println(i)
    }
}