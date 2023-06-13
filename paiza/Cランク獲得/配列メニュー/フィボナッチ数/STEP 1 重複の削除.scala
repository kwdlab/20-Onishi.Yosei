object Main extends App {

    val line = Array(1, 3, 5, 1, 2, 3, 6, 6, 5, 1, 4)
    val result = line.toSet.toArray.sorted

    for (i <- result){
        println(i)
    }
}