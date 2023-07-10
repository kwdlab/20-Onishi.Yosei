package money

class Franc(val amount: Int) extends Money {

    override def currency() = "CHF"    
    override def times(multiplier: Int): Money = new Franc(amount * multiplier)
}