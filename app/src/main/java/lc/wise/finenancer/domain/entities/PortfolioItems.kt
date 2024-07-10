package lc.wise.finenancer.domain.entities

import java.util.Date

interface PortfolioCashInterface : CurrencyInterface {
    var amount: Double
    var price: Double
    var currency: String
    var date: Date
    var priceHistory: MutableMap<Date, Double>
    fun calculateValue(): Double
}

interface PortfolioStockInterface : AssetInterface {
    var amount: Double
    var price: Double
    var currency: String
    var date: Date
    var priceHistory: MutableMap<Date, Double>
    fun calculateValue(): Double
}

data class Cash(
    override val id: Int, //айди 1
    override val name: String, //USD
    override var amount: Double, //100
    override var price: Double, //1
    override var currency: String, //USD
    override var date: Date, //сегодня
) : PortfolioCashInterface {
    override var priceHistory: MutableMap<Date, Double> = mutableMapOf(date to price)
    override fun calculateValue(): Double {
        return amount * price
    }
}

data class Stock(
    override val id: Int, //айди 1
    override val name: String, //акция ГазПрома
    override val totalAmount: Double, //всего 23_673_512_900 акций
    override var amount: Double, //хочу купить 2
    override var price: Double, //стоимость одной 10_000
    override var currency: String, //российских рублей RUB
    override var date: Date,
) : PortfolioStockInterface {
    override var priceHistory: MutableMap<Date, Double> = mutableMapOf(date to price)
    override fun calculateValue(): Double {
        return amount * price
    }
}
