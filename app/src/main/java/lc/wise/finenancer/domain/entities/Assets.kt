abstract class Assets {
    abstract val name: String
    abstract var price: Double
    abstract var amount: Double

    var nameOfDefaultCurrency: String = "USD"

    abstract var priceHistory: MutableMap<Date, Double>

    abstract fun calculateValue(): Double
}