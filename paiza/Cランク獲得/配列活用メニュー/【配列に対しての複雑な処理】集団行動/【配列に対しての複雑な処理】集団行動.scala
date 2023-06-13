import scala.io.StdIn._

object Main extends App {

    val Array(n, q) = readLine().trim().split(" ").map(_.toInt)
    val sq = Array.ofDim[Int](q, 3)
    val people = (1 to n).toArray

    for (i <- 0 until q){
        val tmp = readLine().trim()
        if (tmp == "reverse"){
            sq(i) = Array(1, 0, 0)
        } else {
            val line = tmp.split(" ")
            if (line(0) == "resize"){
                sq(i) = Array(2, line(1).toInt, 0)
            } else {
                sq(i) = Array(0, line(1).toInt, line(2).toInt)
            }
        }
    }

    def sqLoop(cnt: Int, people: Array[Int]): Array[Int] = {
        if (cnt == q){
            return people
        } else {
            val newP = {
                if (sq(cnt)(0) == 0){
                    val tmp2 = people(sq(cnt)(1)-1)
                    people(sq(cnt)(1)-1) = people(sq(cnt)(2)-1)
                    people(sq(cnt)(2)-1) = tmp2
                    people

                } else if (sq(cnt)(0) == 1){
                    people.reverse

                } else if (sq(cnt)(0) == 2 && people.length > sq(cnt)(1)){
                    people.take(sq(cnt)(1))
                } else {
                    people
                }
            }
            sqLoop(cnt+1, newP)
        }
    }

    val result = sqLoop(0, people)
    result.foreach(println)
}
