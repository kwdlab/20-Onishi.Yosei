import scala.io.StdIn._

object Main extends App {

    val n = readLine().toInt
    val a = Array.fill(n)(readLine().trim().split(" ").map(_.toInt))

    def withSort(x: Array[Array[Int]]): Array[Array[Int]] = {
        val tmp = x.sortWith {
            case (Array(key1, value1), Array(key2, value2)) => {
                if (key1 != key2) {
                    key1 > key2
                } else {
                    value1 > value2
                }
            } 
        }
        return tmp
    }

    val result = withSort(a)
    for (i <- result){
        println(i.mkString(" "))
    }
}