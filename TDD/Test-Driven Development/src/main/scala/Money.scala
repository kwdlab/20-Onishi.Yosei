package money

abstract class Money {
    
    protected val amount: Int
    protected val curr: String

    def times(multiplier: Int): Money
    def currency(): String = curr 

    def equals(money: Money): Boolean = amount == money.amount && getClass.equals(money.getClass)
}

object Money {
    def dollar(amount: Int): Money = new Dollar(amount, "USD")
    def franc(amount: Int): Money = new Franc(amount, "CHF")
}
