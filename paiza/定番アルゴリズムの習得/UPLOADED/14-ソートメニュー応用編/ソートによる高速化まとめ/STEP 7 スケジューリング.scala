import scala.io.StdIn._

object Main extends App {

    val n = readLine().toInt
    val campaignSorted = Array.fill(n)(readLine().split(" ").map(_.toInt)).sortBy(_(1))

    val result = campaignSorted.foldLeft((0, 0)) { case ((participated, lastday), campaign) =>
        val (start, end) = (campaign(0), campaign(1))
        if (lastday < start){
            (participated + 1, end)
        }else{
            (participated, lastday)
        }
    }

    println(result._1)
}
//解答例使用済み