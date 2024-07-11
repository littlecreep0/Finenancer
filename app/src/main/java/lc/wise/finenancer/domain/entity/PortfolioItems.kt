package lc.wise.finenancer.domain.entity

import java.util.Date

interface IPortfolioCash : ICurrency {
    var worth: Double
}

data class Cash(
    override val id: Int,
    override val name: String,
    override var worth: Double,
) : IPortfolioCash

interface IPortfolioStock : IAsset {
    var worth: Double
}

data class Stock(
    override val id: Int,
    override val name: String,
    override val totalAmount: Double,
    override var worth: Double,
) : IPortfolioStock
