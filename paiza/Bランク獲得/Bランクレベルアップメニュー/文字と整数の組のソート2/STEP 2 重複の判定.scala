import scala.io.StdIn._

object Main extends App {

    val list = Array("HND", "NRT", "KIX", "NGO", "NGO")

    if (list.length == list.distinct.length){
        println("false")
    } else {
        println("true")
    }
}
