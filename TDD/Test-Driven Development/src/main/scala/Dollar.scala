package money

class Dollar (var amount: Int) {
    
    def times(multiplier: Int): Dollar = {
        return new Dollar(amount * multiplier)
    }
}