import scala.io.StdIn._

object Main extends App {

    val day = readLine().toInt
    val flag = day%7

    if (flag == 1){
        println("Sun")
    } else if (flag == 2){
        println("Mon")
    } else if (flag == 3){
        println("Tue")
    } else if (flag == 4){
        println("Wed")
    } else if (flag == 5){
        println("Thu")
    } else if (flag == 6){
        println("Fri")
    } else if (flag == 0){
        println("Sat")
    }
}
