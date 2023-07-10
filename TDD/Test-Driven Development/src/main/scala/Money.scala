package money

class Money(protected val amount: Int) {

    def equals(money: Money): Boolean = {
        amount == money.amount && getClass().equals(money.getClass())
    }

    def dollar(): Money = {
        new Dollar(amount)
    }
    def franc(): Money = {
        new Franc(amount)
    }
}