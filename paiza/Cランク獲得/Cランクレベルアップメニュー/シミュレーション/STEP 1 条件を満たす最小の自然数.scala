object Main extends App {

    val num = 10000

    def search(count: Int):Int = {
        if ((num+count) % 13 == 0){
            return count
        } else {
            search(count+1)
        }
    }
    println(num+search(0))
}