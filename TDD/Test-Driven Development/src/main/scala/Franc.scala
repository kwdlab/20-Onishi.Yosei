package money

class Franc(val amount: Int) extends Money {

    val curr = "CHF"
    override def times(multiplier: Int): Money = new Franc(amount * multiplier)
}