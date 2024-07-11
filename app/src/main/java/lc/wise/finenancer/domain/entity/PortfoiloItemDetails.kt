package lc.wise.finenancer.domain.entity

import java.util.Date

interface ICashDetails : IPortfolioCash {
    var amount: Double
    var price: Double
    var currency: String
    var date: Date
    var priceHistory: MutableMap<Date, Double>
    fun calculateWorth(): Double
}

data class CashDetails(
    override val id: Int,
    override val name: String,
    override var worth: Double,
    override var amount: Double,
    override var price: Double,
    override var currency: String,
    override var date: Date,
) : ICashDetails {
    override var priceHistory: MutableMap<Date, Double> = mutableMapOf(date to price)
    override fun calculateWorth(): Double {
        return amount * price
    }
}

interface IStockDetails : IPortfolioStock {
    var amount: Double
    var price: Double
    var currency: String
    var date: Date
    var priceHistory: MutableMap<Date, Double>
    fun calculateWorth(): Double
}

data class StockDetails(
    override val id: Int,
    override val name: String,
    override val totalAmount: Double,
    override var worth: Double,
    override var amount: Double,
    override var price: Double,
    override var currency: String,
    override var date: Date,
) : IStockDetails {
    override var priceHistory: MutableMap<Date, Double> = mutableMapOf(date to price)
    override fun calculateWorth(): Double {
        return amount * price
    }
}