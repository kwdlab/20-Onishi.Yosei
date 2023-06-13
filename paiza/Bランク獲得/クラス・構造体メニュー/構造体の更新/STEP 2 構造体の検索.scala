import scala.io.StdIn._

object Main extends App {

    class User(val nickname: String, val old: Int, val birth: String, val state: String)
    
    val n = readLine().toInt
    val usersList: Array[User] = (0 until n).foldLeft(Array.empty[User]) { (users, _) =>
        val rl = readLine().split(" ")
        val user = new User(rl(0), rl(1).toInt, rl(2), rl(3))
        users :+ user
    }    
    val k = readLine().toInt
    
    usersList.foreach(x => 
        if (x.old == k){
            println(x.nickname)
        }
    )
}