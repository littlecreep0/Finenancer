abstract class Currencies: Assets(){
    override val name: String
    override var price: Double
    override var amount: Double

    private val date: Date = Date()
    override var priceHistory: MutableMap<Date, Double> =  mutableMapOf(date to price)

    override fun calculateValue(): Double{
        return amount * price
    }
}

data class USD: Currencies(){
    override val name: String = "USD"
    override val price: Double = 1
}

data class BYN: Currencies(){
    override val name: String = "BYN"
    override val price: Double = 0.3
}

data class EUR: Currencies(){
    override val name: String = "EUR
    override val price: Double = 1.1
}