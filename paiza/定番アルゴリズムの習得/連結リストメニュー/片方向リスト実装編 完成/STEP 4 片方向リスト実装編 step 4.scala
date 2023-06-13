import scala.io.StdIn._

object Main extends App {

    class Node(val value: Int, val next: Int){

        def updateValue(x: Int): Node = {
            new Node(x, next)
        }
        def updateNext(x: Int): Node = {
            new Node(value, x)
        }
    }

    val Array(n, k) = readLine().trim().split(" ").map(_.toInt)
    val list: List[Node] = List(new Node(-1, 1), new Node(-1, -1))

    def addNodeTail(cnt: Int, current: Node, list: List[Node]): List[Node] = {
        if (cnt == n){
            return list 
        } else {
            val tmp = readLine().trim().toInt
            val newNode = new Node(tmp, current.next)
            val newList = list :+ newNode
            val updatedList = newList.updated(newList.indexOf(current), current.updateNext(newList.indexOf(newNode)))
            addNodeTail(cnt+1, newNode, updatedList)
        }
    }
    def deleteTail(cnt: Int, current: Node, list: List[Node]): List[Node] = {
        if (cnt == k){
            return list
        } else if (list(current.next).next == 1){
            val updatedList = list.updated(list.indexOf(current), current.updateNext(1))
            deleteTail(cnt+1, updatedList(0), updatedList)
        } else {
            deleteTail(cnt, list(current.next), list)
        }
    }
    def printOut(current: Int, list: List[Node]): Unit = {
        if (current == 1){
            return
        } else {
            println(list(current).value)
            printOut(list(current).next, list)
        }
    }
    
    val loadList = addNodeTail(0, list(0), list)
    val finalList = deleteTail(0, loadList(0), loadList)
    printOut(finalList(0).next, finalList)
}
