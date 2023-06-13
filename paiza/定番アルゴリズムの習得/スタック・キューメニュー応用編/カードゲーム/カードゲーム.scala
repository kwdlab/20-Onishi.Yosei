import scala.io.StdIn._
import scala.collection.mutable._

object Main extends App {

    val Array(n, k) = readLine().split(" ").map(_.toInt)
    val deck = Queue[Int]()
    val grave = Stack[Int]()
    val exclude = Stack[Int]()

    for (i <- 1 to 40){
        if (i == n){
            deck.enqueue(1)
        } else {
            deck.enqueue(0)
        }
    }    

    def mainFunc(): Int = {
        for (i <- 0 until k){
            val q = readLine().split(" ")
            q(0) match {
                case "game_start" => {
                    for (_ <- 0 until 5){
                        if (deck.dequeue() == 1){
                            return i+1
                        } 
                    }
                }
                case "draw" => {
                    for (_ <- 0 until q(1).toInt){
                        if (deck.dequeue() == 1){
                            return i+1
                        } 
                    }
                }
                case "discard" => {
                    for (_ <- 0 until q(1).toInt){
                        grave.push(deck.dequeue())
                    }
                }
                case "return_from_the_graveyard" => {
                    for (_ <- 0 until q(1).toInt){
                        deck.enqueue(grave.pop())
                    }
                }
                case "exclude" => {
                    for (_ <- 0 until q(1).toInt){
                        exclude.push(deck.dequeue())
                    }
                }
                case "return_from_the_exclusion" => {
                    for (_ <- 0 until q(1).toInt){
                        deck.enqueue(exclude.pop())
                    }
                }
            }
        }
        return -1
    }

    val result = mainFunc()
    if (result == -1) {
        println("Lose")
    } else {
        println(result)
    }
}