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

    val Array(n, q) = readLine().trim().split(" ").map(_.toInt)
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
    def addNodeInsert(cnt: Int, current: Node, list: List[Node], p: Int, x: Int): List[Node] = {
        if (cnt == p-1){
            val newNode = new Node(x, current.next)
            val newList = list :+ newNode
            val updatedList = newList.updated(newList.indexOf(current), current.updateNext(newList.indexOf(newNode)))
            return updatedList
        } else {
            addNodeInsert(cnt+1, list(current.next), list, p, x)
        }
    }
    def deleteInsert(cnt: Int, current: Node, list: List[Node], p: Int): List[Node] = {
        if (cnt == p-1){
            val updatedList = list.updated(list.indexOf(current), current.updateNext(list(current.next).next))
            return updatedList
        } else {
            deleteInsert(cnt+1, list(current.next), list, p)
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
    def queryLoop(cnt: Int, list: List[Node]): List[Node] = {
        if (cnt == q){
            return list
        } else {
            val op = readLine().trim().split(" ").map(_.toInt)
            val newList = 
            op(0) match {
                case 1 => 
                    val p = op(1)
                    val x = op(2)
                    addNodeInsert(0, list(0), list, p, x)
                case 2 => 
                    val p = op(1)
                    deleteInsert(0, list(0), list, p)
            }
            queryLoop(cnt+1, newList)
        }
    }

    val loadList = addNodeTail(0, list(0), list)
    val finalList = queryLoop(0, loadList)
    printOut(finalList(0).next, finalList)
}