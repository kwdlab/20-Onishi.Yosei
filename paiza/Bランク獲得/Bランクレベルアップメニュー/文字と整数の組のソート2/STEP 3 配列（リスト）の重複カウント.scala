import scala.io.StdIn._

object Main extends App {

    val list = Array("HND", "NRT", "KIX", "NGO", "NGO", "NGO", "NGO", "NGO")
    val solo = list.distinct
    
    for (i <- solo){
        if (list.count(x => x == i) > 1){
            println(list.count(x => x == i))
        }
    }
}
