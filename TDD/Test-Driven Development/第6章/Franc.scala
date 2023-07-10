package money

class Franc(amount: Int) extends Money(amount) {

    def times(multiplier: Int): Franc = {
        new Franc(amount * multiplier)
    }
}