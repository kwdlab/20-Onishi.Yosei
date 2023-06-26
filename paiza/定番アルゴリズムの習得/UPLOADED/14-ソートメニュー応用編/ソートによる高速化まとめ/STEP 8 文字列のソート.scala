import scala.io.StdIn._

object Main extends App {

    val n = readLine().toInt
    val s = Array.ofDim[String](n)

    for (i <- 0 until n) {
        s(i) = readLine()
    }

    def withSort(x: Array[String]): Array[String] = {
        val tmp = x.sortWith {
            case (value1, value2) => {
                if (value1.length != value2.length) {
                    value1.length < value2.length
                } else {
                    value1 < value2
                }
            } 
        }
        return tmp
    }

    val result = withSort(s)
    for (i <- result){
        println(i)
    }
}
