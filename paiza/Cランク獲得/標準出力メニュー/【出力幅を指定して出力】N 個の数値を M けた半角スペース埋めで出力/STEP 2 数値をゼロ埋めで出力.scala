import scala.io.StdIn._

object Main extends App {

    val num = readLine()
    
    if (num.length.toInt==1){
        println(s"00${num}")  
    } 
    else if (num.length.toInt==2){
        println(s"0${num}")  
    }
    else if (num.length.toInt==3){
        println(s"${num}")  
    }
}