object Main extends App {

    val num = 9
    var result = ""

    for (i <- 0 until num){
        result = result + s"${8*(i.toInt+1)}"

        if (i < num-1){
            result = result + " "
        }
    }
    println(result)
}
