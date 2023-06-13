import scala.io.StdIn._

object Main extends App {

    val Array(n, m) = readLine().split(" ").map(_.toInt)
    val A = readLine().split(" ")
    val B = readLine().split(" ")
    val Xm = readLine().split(" ").map(_.toInt)

    def interruptQueue(queue: Array[String], name: Array[String], index: Array[Int], count: Int, target: Int): Array[String] = {
        val nTmp = name(count)
        val iTmp = index(count)
        val line = queue.take(iTmp-1) ++ Array(nTmp) ++ queue.drop(iTmp-1)

        if (line.length < target){
            interruptQueue(line, name, index, count+1, target)
        }else{
            return line
        } 
    }
    interruptQueue(A, B, Xm, 0, n+m).foreach(println)
}
