import scala.io.StdIn._
import scala.collection.mutable.ArrayBuffer
import scala.collection.mutable.Map

object Main extends App {

    val treeMap: Map[Int, node] = Map.empty
    
    class node(val name: Int){
        val leftChild = ArrayBuffer.empty[Int]
        val rightChild = ArrayBuffer.empty[Int]
        val parent = ArrayBuffer.empty[Int]

        def setChildren(x: Int, tag: String) = {
            tag match {
                case "L" => leftChild += x
                case "R" => rightChild += x
            }
        }
        def setParent(x: Int) = {
            parent += x
        }
        def getChildren(tag: String):ArrayBuffer[Int] = {
            tag match {
                case "L" => return leftChild
                case "R" => return rightChild
            }
        }
    }

    val Array(n, k, r) = readLine().trim().split(" ").map(_.toInt)
    treeMap.put(r, new node(r))

    for (_ <- 1 until n){
        val line = readLine().trim().split(" ")
        val a = line(0).toInt
        val b = line(1).toInt
        val lr = line(2)
        if (!(treeMap.contains(a))){
            treeMap.put(a, new node(a))
        }
        if (!(treeMap.contains(b))){
            treeMap.put(b, new node(b))
        }
        treeMap(a).setChildren(b, lr)
        treeMap(b).setParent(a)
    }
    for (_ <- 0 until k){
        val linek = readLine().trim().split(" ")
        val v = linek(0).toInt
        val lrk = linek(1)
        if (treeMap.contains(v)){
            println(treeMap(v).getChildren(lrk).mkString(" "))
        } else {
            println()
        }
    }
}
