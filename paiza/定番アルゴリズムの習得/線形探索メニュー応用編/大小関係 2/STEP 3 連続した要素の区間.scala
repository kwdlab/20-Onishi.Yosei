import scala.io.StdIn._

object Main extends App {

    val Array(n, x, k) = readLine().split(" ").map(_.toInt)
    val an = readLine().split(" ").map(_.toInt)

    def countUp(i: Int, line: List[Array[Int]], count: Int): Int = {
        if (i == line.length){
            return count
        } else {
            if (line(i)(.length == line(i)(.count(_ == x)){
                countUp(i+1, line, count+1)
            } else {
                countUp(i+1, line, count)
            }
        }
    }

    println(countUp(0, an.sliding(k).toList, 0))
}