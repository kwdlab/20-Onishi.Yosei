import scala.io.StdIn._

object Main extends App {

    class User(val nickname: String, val old: Int, val birth: String, val state: String){
        def printOut = {
            println(s"${nickname} ${old} ${birth} ${state}")
        }
        def copyNewNameUser(cName: String):User  = {
            new User(cName, old, birth, state)
        }
    }
    
    val Array(n, k) = readLine().split(" ").map(_.toInt)
    val usersList: Array[User] = (0 until n).foldLeft(Array.empty[User]) { (users, _) =>
        val rl = readLine().split(" ")
        val user = new User(rl(0), rl(1).toInt, rl(2), rl(3))
        users :+ user
    }    

    for (i <- 0 until k){
        val ann = readLine().split(" ")
        val tmp = usersList(ann(0).toInt-1).copyNewNameUser(ann(1))
        usersList(ann(0).toInt-1) = tmp
    }

    usersList.foreach(_.printOut)
}
