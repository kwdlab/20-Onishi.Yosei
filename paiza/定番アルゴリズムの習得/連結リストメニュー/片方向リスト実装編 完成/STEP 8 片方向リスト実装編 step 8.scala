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

    val Array(n, l, r) = readLine().trim().split(" ").map(_.toInt)
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
    def deleteRange(l: Int, r: Int, list: List[Node]): List[Node] = {
        def searchIndex(current: Int, count: Int, target: Int): Int = {
            if (current == 1){
                return -1
            } else if (count == target){
                return current
            } else {
                searchIndex(list(current).next, count+1, target)
            }
        }

        val fromIndex = searchIndex(list(0).next, 1, l-1)
        val toIndex = searchIndex(list(0).next, 1, r)
        val finalList = {
            if ((fromIndex != -1 && toIndex != -1) || l != r){
                list.updated(fromIndex, list(fromIndex).updateNext(toIndex))
            } else {
                list
            }
        }
        return finalList
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
    val finalList = deleteRange(l, r, loadList)
    printOut(finalList(0).next, finalList)
}