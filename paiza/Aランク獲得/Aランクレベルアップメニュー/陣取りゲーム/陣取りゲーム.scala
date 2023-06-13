import scala.io.StdIn._

object Main extends App {

    val HW = readLine().split(" ").map(_.toInt)
    val H = HW(0)
    val W = HW(1)
    val s = Array.ofDim[String](H, W)
    var sums = Array(1, 1)
    var flagPass = true
    val abPoint = Array.fill(2)(List.empty[(Int, Int, Int)])

    val (count, aadd) = {
        if (readLine() == "B") {
            (1, 1)
        } else {
            (0, 0)
        }
    }

    for (y <- 0 until H) {
        s(y) = readLine().split("")
        for (x <- 0 until W) {
            if (s(y)(x) == "A") {
                abPoint(0) = abPoint(0) ++ List((y, x, aadd))
            }
            if (s(y)(x) == "B") {
                abPoint(1) = abPoint(1) ++ List((y, x, 0))
            }
        }
    }

    while (abPoint(0).nonEmpty || abPoint(1).nonEmpty) {
        if (abPoint(count % 2).isEmpty) {
            count = count + 1
            flagPass = false
        }

        var (y, x, n) = abPoint(count % 2).head
        if (count / 2 < n && flagPass) {
            count = count + 1
            val tmp = abPoint(count % 2).head
            y = tmp(0)
            x = tmp(1)
            n = tmp(2)
        }

        abPoint(count % 2) = abPoint(count % 2).tail
        val ab = if (count % 2 == 0) "A" else "B"

        def addToAbPoint(y: Int, x: Int, n: Int): Unit = {
            if (y >= 0 && y < H && x >= 0 && x < W && s(y)(x) == ".") {
                s(y)(x) = ab
                sums(count % 2) = sums(count % 2) + 1
                abPoint(count % 2) = abPoint(count % 2) ++ List((y, x, n + 1))
            }
        }

        addToAbPoint(y - 1, x, n)
        addToAbPoint(y + 1, x, n)
        addToAbPoint(y, x - 1, n)
        addToAbPoint(y, x + 1, n)
    }

    println(s"${sums(0)} ${sums(1)}")
    if (sums(0) > sums(1)) {
        println("A")
    } else if (sums(0) == sums(1)) {
        println("Draw")
    } else {
        println("B")
    }
}

//解答例使用済み
//断念
/*
import scala.io.StdIn._
import scala.collection.mutable.Queue
import math.abs

object Main extends App {
 
    val line = readLine().split(" ").map(_.toInt)
    val H = line(0)
    val W = line(1)
    val N = readLine()
    val Sh = Array.ofDim[String](H, W)

    val countMA : Int = N match {
        case "A" => { 10000 }
        case "B" => { 20000 }
    }
    val countMB : Int = N match {
        case "A" => { 20000 }
        case "B" => { 10000 }
    }

    for (i <- 0 until H){
        Sh(i) = readLine().split("")
    }

    def AstartSearch(board: Array[Array[String]]): (Int, Int) = {
        for (i <- 0 until H; j <- 0 until W){
            if (board(i)(j) == "A") {
                return (i, j)
            }
        }
        return (-1, -1)
    }
    def BstartSearch(board: Array[Array[String]]): (Int, Int) = {
        for (i <- 0 until H; j <- 0 until W){
            if (board(i)(j) == "B") {
                return (i, j)
            }
        }
        return (-1, -1)
    }
    def inMap(y: Int, x: Int) : Boolean = {
        (0 <= y && y < H && 0 <= x && x < W)
    }
    def noObject(board: Array[Array[String]], y: Int, x: Int) : Boolean = {
        (board(y)(x) != "#")
    }

    def nextToPlot(board: Array[Array[String]], aTup: (Int, Int), bTup: (Int, Int), rank: (Int, Int)): Array[Array[String]] = {
        val (ay, ax) = aTup
        val (by, bx) = bTup
        val (countA, countB) = rank
        board(ay)(ax) = countA.toString
        board(by)(bx) = countB.toString
        val queueA = Queue[(Int, Int, Int)]((ay, ax, countA))
        val queueB = Queue[(Int, Int, Int)]((by, bx, countB))
        while (queueA.nonEmpty && queueB.nonEmpty) {
            val (ay, ax, countA) = queueA.dequeue()
            val (by, bx, countB) = queueB.dequeue()
            def nextSub(y: Int, x: Int, z: Queue[(Int, Int, Int)], w: Int) = {
                if (inMap(y, x)){
                    if (noObject(board, y, x)){
                        val t1 = board(y)(x)
                        val t2 = w + 1
                        if (t1 == "."){
                            board(y)(x) = s"${t2}"
                            z.enqueue((y, x, t2))
                        }else if (t1.toInt%10000 >= t2%10000 && t1.toInt > t2 && abs(t1.toInt-t2)>=10000){
                            board(y)(x) = s"${t2}"
                            z.enqueue((y, x, t2))
                        }
                    }
                }
            }
            def callA() = {
                nextSub(ay-1, ax, queueA, countA)
                nextSub(ay+1, ax, queueA, countA)
                nextSub(ay, ax-1, queueA, countA)
                nextSub(ay, ax+1, queueA, countA)
            }
            def callB() = {
                nextSub(by-1, bx, queueB, countB)
                nextSub(by+1, bx, queueB, countB)
                nextSub(by, bx-1, queueB, countB)
                nextSub(by, bx+1, queueB, countB)
            }

            if (N == "A"){
                callA()
                callB()
            } else {
                callB()
                callA()
            }
        }
        return board
    }

    val result = nextToPlot(Sh, AstartSearch(Sh), BstartSearch(Sh), (countMA, countMB))
    
    def resultCount(board: Array[Array[String]]): (Int, Int) = {
        var cupA = 0
        var cupB = 0
        for (i <- 0 until H; j <- 0 until W){
            if (countMA <= board(i)(j).toInt && board(i)(j).toInt < countMA + 10000) {
                cupA = cupA + 1
            }
            if (countMB <= board(i)(j).toInt && board(i)(j).toInt < countMB + 10000) {
                cupB = cupB + 1
            }
        }
        return (cupA, cupB)
    }
    def printOut(A: Int, B: Int) = {
        println(s"${A} ${B}")
        if(A > B){
            println("A")
        } else if(A < B){
            println("B")
        }
    }

    val (x, y) = resultCount(result)
    printOut(x, y)
}
*/