import scala.io.StdIn._
import scala.collection.mutable.Queue
object Main extends App {

    val Array(a, b) = readLine().split(" ").map(_.toInt)
    val q = readLine().toInt
    val H = Array.fill(100)(Array.empty[Int])

    for (_ <- 0 until q) {
        val Array(i, x) = readLine().split(" ").map(_.toInt)
        val tmp = (a*x + b) % 100

        i match{
            case 1 => H(tmp) = H(tmp) ++ Array(x)
            case 2 => containsX()
                def containsX():Unit = {
                    for (i <- H){
                        if (i.contains(x)){
                            println("Yes")
                            return
                        }
                    }
                    println("No")
                    return
                }
        }
    }

    for (i <- H){
        println(i.mkString(" "))
    }
}