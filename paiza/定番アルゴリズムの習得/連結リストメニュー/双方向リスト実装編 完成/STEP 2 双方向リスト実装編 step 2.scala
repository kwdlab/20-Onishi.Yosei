import scala.io.StdIn._

object Main extends App {

    class Node(val value: Int, val prev: Int, val next: Int){

        def updateValue(x: Int): Node = {
            new Node(x, prev, next)
        }
        def updatePrev(x: Int): Node = {
            new Node(value, x, next)
        }
        def updateNext(x: Int): Node = {
            new Node(value, prev, x)
        }
    }

    val n = readLine().trim().toInt
    val list: List[Node] = List(new Node(-1, -1, 1), new Node(-1, 0, -1))

    def addNodeHead(cnt: Int, current: Node, list: List[Node]): List[Node] = {
        if (cnt == n){
            return list 
        } else {
            val tmp = readLine().trim().toInt
            val newNode = new Node(tmp, 0, list(0).next)
            val newList = list :+ newNode
            val tmpList = newList.updated(newList.indexOf(current), current.updatePrev(newList.indexOf(newNode)))
            val updatedList = tmpList.updated(0, tmpList(0).updateNext(tmpList.indexOf(newNode)))
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