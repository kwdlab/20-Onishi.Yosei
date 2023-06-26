import scala.io.StdIn._

object Main extends App {

    class node(a: Int, b: Int, c: Int, d: Int){
        var value = a
        var prev = b
        var now = c
        var next = d

        def getValue() : Int = {
            value
        }
        def getNext() : Int = {
            next
        }
        def getNow() : Int = {
            now
        }
        def getPrev() : Int = {
            prev
        }
        def updateValue(x: Int) = {
            value = x
        }
        def updateNext(x: Int) = {
            next = x
        }
        def updateNow(x: Int) = {
            now = x
        }
        def updatePrev(x: Int) = {
            prev = x
        }
    }

    val Array(n, k) = readLine().split(" ").map(_.toInt)
    val list = Array.ofDim[node](1024)

    list(0) = new node(-1, -1, 0, 1023)
    list(1023) = new node(-1, 0, 1023, -1)
    var emptyMinIndex = 1

    def addTail() = {
        val data = readLine().trim().toInt
        list(emptyMinIndex) = new node(data, list(1023).getPrev, emptyMinIndex, 1023)
        list(list(emptyMinIndex).getPrev).updateNext(emptyMinIndex)
        list(1023).updatePrev(emptyMinIndex)
        emptyMinIndex = emptyMinIndex + 1
    }
    def addTop() = {
        val data = readLine().trim().toInt
        list(emptyMinIndex) = new node(data, 0, emptyMinIndex, list(0).getNext)
        list(list(emptyMinIndex).getNext).updatePrev(emptyMinIndex)
        list(0).updateNext(emptyMinIndex)
        emptyMinIndex = emptyMinIndex + 1
    }
    def deleteTail() = {
        list(list(list(1023).getPrev).getPrev).updateNext(1023)
        list(1023).updatePrev(list(list(1023).getPrev).getPrev)
    }
    def deleteTop() = {
        list(list(list(0).getNext).getNext).updatePrev(0)
        list(0).updateNext(list(list(0).getNext).getNext)
    }

    for (i <- 0 until n){
        addTail()
    }
    for (i <- 0 until k){
        deleteTop()
    }

    def printOut(list: Array[node]) = {
        var next = list(0).getNext
        while (next != 1023){
            println(list(next).getValue)
            next = list(next).getNext
        }
    }
    printOut(list)
}
