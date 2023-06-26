import scala.io.StdIn._
import scala.collection.mutable.ArrayDeque

object Main extends App {

    def operationMain(): Unit = {
        val q = readLine().toInt
        val dumbbell = ArrayDeque[Long]()

        for (i <- 0 until q){
            val tmp = readLine().split(" ")
            tmp(0) match {
                case "ADD_RIGHT" => dumbbell.append(tmp(1).toLong)

                case "ADD_LEFT" => dumbbell.prepend(tmp(1).toLong)

                case "REMOVE_RIGHT" => dumbbell.removeLast()

                case "REMOVE_LEFT" => dumbbell.removeHead()
            }
        }
        println(dumbbell.sum)
    }

    operationMain()
}