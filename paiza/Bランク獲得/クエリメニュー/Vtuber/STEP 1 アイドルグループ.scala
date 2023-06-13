import scala.io.StdIn._

object Main extends App {
     
    val Array(n, k) = readLine().trim().split(" ").map(_.toInt)
    val name = Set.fill(n)(readLine().trim())
        
    def memberDB(cnt: Int, name: Set[String]): Unit ={
        if (cnt == k){
            return
        } else {
            val op = readLine().trim().split(" ")
            if (op(0) == "join"){
                memberDB(cnt+1, name ++ Set(op(1)))
            } else if (op(0) == "leave") {
                memberDB(cnt+1, name -- Set(op(1)))
            } else {
                for (i <- name.toList.sorted){ println(i) }
                memberDB(cnt+1, name)
            }
        }
    }
    memberDB(0, name)
}