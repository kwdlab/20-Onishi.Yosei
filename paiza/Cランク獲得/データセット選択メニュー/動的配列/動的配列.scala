import scala.io.StdIn._

object Main extends App {

    val Array(n, q) = readLine().split(" ").map(_.toInt)
    val a = readLine().split(" ").map(_.toInt)

    val query: Array[Array[Int]] = (0 until q).foldLeft(Array.empty[Array[Int]]) { (array, _) =>
        val tmp = readLine().trim().split(" ").map(_.toInt)
        tmp(0) match {
            case 1 => 
                array :+ Array(1, 0)
            case 2 =>
                array :+ Array(2, 0)
            case _ =>
                array :+ Array(0, tmp(1))
        }
    }

    def operation(cnt: Int, query: Array[Array[Int]], a: Array[Int]):Unit = {
        if (cnt == query.length){
            return
        } else {
            val i = query(cnt)
            val newA = i(0) match {
                case 1 => 
                    a.dropRight(1)
                case 2 => 
                    println(a.mkString(" "))
                    a
                case _ => 
                    a :+ i(1)
            }
            operation(cnt+1, query, newA) 
        }
    }
    operation(0, query, a)
}