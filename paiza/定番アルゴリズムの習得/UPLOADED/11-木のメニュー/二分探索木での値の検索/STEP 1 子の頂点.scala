import scala.io.StdIn._
import scala.collection.mutable.Map

object Main extends App {
    
    class Node(val name: Int, val leftChild: List[Int], val rightChild: List[Int], val parent: List[Int]){

        def setChildren(x: Int, tag: String): Node = {
            tag match {
                case "L" => new Node(name, x :: leftChild, rightChild, parent)
                case "R" => new Node(name, leftChild, x :: rightChild, parent)
            }
        }
        def setParent(x: Int): Node = {
            new Node(name, leftChild, rightChild, x :: parent)
        }
        def getChildren(tag: String):List[Int] = {
            tag match {
                case "L" => leftChild
                case "R" => rightChild
            }
        }
    }

    val Array(n, k, r) = readLine().trim().split(" ").map(_.toInt)
    val treeMap: Map[Int, Node] = Map.empty
    treeMap.put(r, new Node(r, Nil, Nil, Nil))

    for (_ <- 1 until n){
        val line = readLine().trim().split(" ")
        val a = line(0).toInt
        val b = line(1).toInt
        val lr = line(2)
        if (!(treeMap.contains(a))) treeMap.put(a, new Node(a, Nil, Nil, Nil))
        if (!(treeMap.contains(b))) treeMap.put(b, new Node(b, Nil, Nil, Nil))
        treeMap.update(a, treeMap(a).setChildren(b, lr))
        treeMap.update(b, treeMap(b).setParent(a))
    }
    for (_ <- 0 until k){
        val linek = readLine().trim().split(" ")
        val v = linek(0).toInt
        val lrk = linek(1)
        if (treeMap.contains(v)) println(treeMap(v).getChildren(lrk).mkString(" "))
        else println()
    }
}
