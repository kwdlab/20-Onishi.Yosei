import scala.io.StdIn._
import scala.collection.mutable.ArrayBuffer

object Main extends App {

    val n = readLine().toInt
    val matrix = Array.fill[Int](n, n+1)(0)

    for (i <- 0 until n){
        matrix(i)(n) = i+1
    }
    
    for (i <- 1 until n){
        val Array(a, b) = readLine().split(" ").map(_.toInt)
        matrix(a-1)(b-1) = 1
        matrix(b-1)(a-1) = 1
    }

    def searchCenternode(n: Int, mat: Array[Array[Int]]): Array[Int] = {
        def removeMat(list: Array[Int], tmp: Array[Array[Int]]): Array[Array[Int]] = {
            tmp.zipWithIndex
            .filterNot(index => list.contains(index._2))
            .map { case (index, _) => index.zipWithIndex.filterNot(index => list.contains(index._2)).map(_._1) }
        }

        val leafNodes = mat.zipWithIndex.filter(row => row._1.dropRight(1).sum == 1).map(_._2)   
        if (mat.length > 2) {
            val newMat = removeMat(leafNodes, mat)
            return searchCenternode(newMat.length, newMat)
        } else {
            return mat.map(_.last)
        } 
    }

    searchCenternode(n, matrix).sorted.foreach(println)
}

        /*
        def removeMat(list: Array[Int], tmp: Array[Array[Int]]): Array[Array[Int]] = {
            val (index, nList) = {
                if (list.length > 1){
                    (list(0), list.drop(1))
                } else {
                    (list(0), Array.empty[Int])
                }
            }

            val newArray = ArrayBuffer.empty[Array[Int]]
            for (i <- tmp.indices) {
                if (i != index) {
                    newArray+= tmp(i).patch(index, Nil, 1)
                }
            }

            if (nList.isEmpty){
                return newArray.toArray
            } else {
                return removeMat(nList, newArray.toArray)
            }
        }*/