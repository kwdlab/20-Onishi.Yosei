import scala.io.StdIn._

object Main extends App {
    val Array(n, r) = readLine().trim().split(" ").map(_.toInt)

    def printOut():Boolean = {
        for (_ <- 1 until n){
            val Array(a, b) = readLine().trim().split(" ").map(_.toInt)
            if (a < b) {
                println("NO")
                return false
            }
        }
        true
    }  
    if (printOut) println("YES")
}
//解答例使用済み
//予期しない入力に対する失敗

/*
import scala.io.StdIn._
import scala.collection.mutable.ArrayBuffer
import scala.collection.mutable.Map

object Main extends App {

    val treeMap: Map[Int, node] = Map.empty
    
    class node(val value: Int){
        val children = ArrayBuffer.empty[Int]
        val parents = ArrayBuffer.empty[Int]

        def setChildren(x: Int) = {
            children += x
        }
        def setParents(x: Int) = {
            parents += x
        }
        def getValue():Int = {
            return value
        }
    }

    val Array(n, r) = readLine().trim().split(" ").map(_.toInt)
    treeMap.put(r, new node(r))

    for (_ <- 1 until n){
        val Array(a, b) = readLine().trim().split(" ").map(_.toInt)
        if (!(treeMap.contains(a))){
            treeMap.put(a, new node(a))
        }
        if (!(treeMap.contains(b))){
            treeMap.put(b, new node(b))
        }
        treeMap(a).setChildren(b)
        treeMap(b).setParents(a)
    }

    def searchTree(parent: node, vis: Set[Int]): Boolean = {
        def condition(): Boolean = {
            parent.children.forall(_ <= parent.getValue())
        }

        if (vis.contains(parent.getValue())) {
            return false
        } else if (condition()) {
            val newVis = vis + parent.getValue()
            val result = parent.children.map(child => searchTree(treeMap(child), newVis))
            return result.forall(_ == true)
        } else {
            return false
        }
    }

    if (searchTree(treeMap(r), Set.empty)){
        println("YES")
    } else {
        println("NO")
    }
}
*/