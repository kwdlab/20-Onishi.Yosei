import scala.io.StdIn._

object Main extends App {

    val S = readLine()
    val Snum = S.split(Array('+', '-')).map(_.toInt)
    var Smiplus : Array[Int] = Array.empty
    var result : Array[Int] = Array.empty
    var count = -1

    for (i <- S){
        if (i == '+'){
            Smiplus =  Smiplus ++ Array(1)
        } else if (i == '-'){
            Smiplus =  Smiplus ++ Array(-1)
        }
    }

    for (i <-0 until Snum.length){
        if (i == 0){
            result = Array(Snum(i).toInt)
        }else{
            result = result ++ Array(Smiplus(count)*(Snum(i)))
        }
        count = count + 1
    }
    println(result.sum)
}