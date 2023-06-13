import scala.io.StdIn._

object Main extends App {

    val num = readLine().toInt

    for (i <- 0 until num){
        val line = readLine()
        
        if (line.length.toInt==1){
            println(s"  ${line}")  
        } 
        else if (line.length.toInt==2){
            println(s" ${line}")  
        }
        else if (line.length.toInt==3){
            println(s"${line}")  
        }
    }
}