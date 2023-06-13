import scala.io.StdIn._

object Main extends App {

    val map = Map(
        "Kyoko" -> "B",
        "Rio" -> "O",
        "Tsubame" -> "AB",
        "KurodaSensei" -> "A",	
        "NekoSensei" -> "A"
    )

    val name = Array("Kyoko", "Rio", "Tsubame", "KurodaSensei", "NekoSensei")
    
    for (i <- name){
        println(i + " " + map(i))
    }
}
