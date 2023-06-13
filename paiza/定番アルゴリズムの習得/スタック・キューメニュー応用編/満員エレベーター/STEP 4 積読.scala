import scala.io.StdIn._
import scala.collection.mutable.Stack

object Main extends App {

    val n = readLine().trim().toInt
    val bookStack = Stack[Int]()
    var bookCount = 0

    for (_ <- 0 until n) {
        val query = readLine().split(" ")
        val command = query(0)

        if (command == "buy_book") {
            val pages = query(1).toInt
            bookStack.push(pages)
            bookCount += 1
        } else if (command == "read") {
            val pagesToRead = query(1).toInt
            var pagesLeft = pagesToRead
            var booksToRemove = Stack[Int]()

            while (pagesLeft > 0 && !bookStack.isEmpty) {
                val topBook = bookStack.pop()

                if (pagesLeft >= topBook) {
                    pagesLeft -= topBook
                    bookCount -= 1
                } else {
                    booksToRemove.push(topBook - pagesLeft)
                    pagesLeft = 0
                }
            }
            while (!booksToRemove.isEmpty) {
                bookStack.push(booksToRemove.pop())
            }
        }
    }

    println(bookCount)
    println(bookStack.sum)
}
//解答例使用済み
//断念

/*
import scala.io.StdIn._
import scala.collection.mutable.Stack

object Main extends App {

    val n = readLine().trim().toInt
    val Q = Stack[Int]()

    for (_ <- 0 until n){
        val q = readLine().split(" ")
        q(0) match {
            case "buy_book" => Q.push(q(1).toInt)
            case "read" => {
                var read = q(1).toInt
                while (read != 0){
                    val page = Q.pop()
                    if (read <= page){
                        Q.push(page - read)
                        read = 0
                    }
                    else {
                        read = read - page
                    }
                }
            }
        }
    }

    println(Q.length)
    println(Q.sum)
}
*/