package money

class Dollar(val amount: Int) extends Money {

    override def currency() = "USD"
    override def times(multiplier: Int): Money = new Dollar(amount * multiplier)
}