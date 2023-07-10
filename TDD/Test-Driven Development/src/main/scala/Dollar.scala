package money

class Dollar(val amount: Int, val curr: String) extends Money {
    override def times(multiplier: Int): Money = Money.dollar(amount * multiplier)
}