package money

class Franc(val amount: Int) extends Money {
    override def times(multiplier: Int): Money = {
        new Franc(amount * multiplier)
    }
}