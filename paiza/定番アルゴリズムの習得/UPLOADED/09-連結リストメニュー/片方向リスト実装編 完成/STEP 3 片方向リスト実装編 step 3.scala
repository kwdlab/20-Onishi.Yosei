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

    val n = readLine().trim().toInt
    val list: List[Node] = List(new Node(-1, 1), new Node(-1, -1))

    def addNodeHead(cnt: Int, current: Node, list: List[Node]): List[Node] = {
        if (cnt == n){
            return list 
        } else {
            val tmp = readLine().trim().toInt
            val newNode = new Node(tmp, list(0).next)
            val newList = list :+ newNode
            val updatedList = newList.updated(0, newList(0).updateNext(newList.indexOf(newNode)))
            addNodeHead(cnt+1, newNode, updatedList)
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
    
    val finalList = addNodeHead(0, list(0), list)
    printOut(finalList(0).next, finalList)
}