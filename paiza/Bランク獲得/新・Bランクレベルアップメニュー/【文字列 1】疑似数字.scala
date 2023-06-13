import scala.io.StdIn._

object Main extends App {

    val S = readLine()

    def numberIndex(input: String) : Array[Int] = {
        var result : Array[Int] = Array.empty
        for (i <- 0 until input.length){
            if (input(i).isDigit){
                result = result ++ Array(i) 
            }
        }
        return result
    } 

    val core : Array[Int] = numberIndex(S)

    for (i <- 0 until core.length){
        for (j <- i until core.length){
            println( S.drop(core(i)).take(core(j)-core(i)+1) )
        }
    }
}