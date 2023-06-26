import scala.io.StdIn._

object Main extends App {

    val n = readLine().toInt
    val an = readLine().split(" ").map(_.toInt)

    def countUp(i: Int, line: List[Array[Int]], count: Int): Int = {
        if (i == line.length){
            return count
        } else {
            if ((line(i)(0) < line(i)(1) && line(i)(1) > line(i)(2)) && (line(i)(0) > line(i)(1) && line(i)(1) < line(i)(2))){
                countUp(i+1, line, count+2)
            } else {
                if (line(i)(0) < line(i)(1) && line(i)(1) > line(i)(2)){
                    countUp(i+1, line, count+1)
                }
                else if (line(i)(0) > line(i)(1) && line(i)(1) < line(i)(2)){
                    countUp(i+1, line, count+1)
                }
                else {
                    countUp(i+1, line, count)
                }
            }   
        }
    }

    println(countUp(0, an.sliding(3).toList, 0))
}