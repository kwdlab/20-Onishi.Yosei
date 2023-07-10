package money

class Franc(val amount: Int, val curr: String) extends Money {
    override def times(multiplier: Int): Money = Money.franc(amount * multiplier)
}