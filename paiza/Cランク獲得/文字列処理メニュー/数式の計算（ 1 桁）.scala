import scala.io.StdIn._

object Main extends App {

    val S = readLine().split("")
    var result : Array[Int] = Array.empty
    var miplus = 1
    var count = 0

    for (i <- S){
        if (count == 0 || count % 2 == 0){
            result = result ++ Array(miplus*(i.toInt))
        } else {
            if (i == "+"){
                miplus =  +1
            } else {
                miplus = -1
            }
        }
        count = count + 1
    }
    println(result.sum)
}