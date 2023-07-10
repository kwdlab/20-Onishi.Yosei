package money

class Money(val amount: Int, val curr: String) {
    
    def times(multiplier: Int): Money = new Money(amount * multiplier, curr)
    def currency(): String = curr 

    def equals(money: Money): Boolean = amount == money.amount && currency().equals(money.currency())
}

object Money {
    def dollar(amount: Int): Money = new Money(amount, "USD")
    def franc(amount: Int): Money = new Money(amount, "CHF")
}
