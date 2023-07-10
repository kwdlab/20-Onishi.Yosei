package money

class Dollar(val amount: Int) extends Money {

    val curr = "USD"

    override def times(multiplier: Int): Money = new Dollar(amount * multiplier)
}