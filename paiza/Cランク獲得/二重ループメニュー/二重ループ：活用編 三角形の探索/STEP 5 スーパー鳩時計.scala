object Main extends App {

    for (i <- 0 to 23){
        for (j <- 0 to 59){
            val num = i + j
            if (num%15 == 0 || num == 0){
                println("FIZZBUZZ")
            } else if (num%3 == 0){
                println("FIZZ")
            } else if (num%5 == 0){
                println("BUZZ")
            } else {
                println()
            }
        }
    }
}