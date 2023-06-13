import scala.io.StdIn._
import scala.collection.mutable.Queue

object Main extends App {

    val Array(n, k) = readLine().split(" ").map(_.toInt)
    val paiza = Queue[String]()
    val kyoko = Queue[String]()
    val winner = Array.ofDim[String](k)

    for (_ <- 0 until n){
        val tmp = readLine().split(" ")
        paiza.enqueue(tmp(0))
        kyoko.enqueue(tmp(1))
    }

    for (i <- 0 until k){
        val tmp = readLine().split(" ")
        val paizaH = paiza.dequeue()
        val kyokoH = kyoko.dequeue()

        paizaH match {
            case "R" => kyokoH match {
                case "R" => 
                case "S" => winner(i) = "paiza"
                case "P" => winner(i) = "kyoko"
            }
            case "S" => kyokoH match {
                case "R" => winner(i) = "kyoko"
                case "S" => 
                case "P" => winner(i) = "paiza"
            }
            case "P" => kyokoH match {
                case "R" => winner(i) = "paiza"
                case "S" => winner(i) = "kyoko"
                case "P" => 
            }
        }
        tmp(0) match {
            case "push" => paiza.enqueue(paizaH)
            case "discard" =>
        }
        tmp(1) match {
            case "push" => kyoko.enqueue(kyokoH)
            case "discard" =>
        }
    } 

    if (winner.count(_ == "paiza") > winner.count(_ == "kyoko")){
        println("paiza")
    } else if (winner.count(_ == "paiza") < winner.count(_ == "kyoko")){
        println("kyoko")
    } else {
        println("draw")
    }
}