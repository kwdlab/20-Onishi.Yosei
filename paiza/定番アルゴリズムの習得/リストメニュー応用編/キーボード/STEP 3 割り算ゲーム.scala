import scala.io.StdIn._

object Main extends App {

    val Array(n, q) = readLine().split(" ").map(_.toInt)

    def operationDivision(): Unit = {
        var A = readLine().split(" ").map(_.toInt).toList
        val B = readLine().split(" ").map(_.toInt).toList

        for (i <- B) {
            A = A.filter(_ % i != 0)
        }

        if (A.isEmpty){
            println("You")
        } else {
            println("Kyoko")
            println(A.mkString(" "))
        }
    }

    operationDivision()
}