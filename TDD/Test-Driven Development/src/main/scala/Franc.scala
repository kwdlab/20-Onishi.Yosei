package money

class Franc (private val amount: Int) {

    def times(multiplier: Int): Franc = {
        new Franc(amount * multiplier)
    }

    def equals(franc: Franc): Boolean = {
        amount == franc.amount
    }
}