package lc.wise.finenancer.domain.entity

interface IPortfolio {
    val id: Int
    val name: String
    val cashList: List<Cash>
    val stockList: List<Stock>
}

data class Portfolio(
    override val id: Int,
    override val name: String,
    override val cashList: List<Cash>,
    override val stockList: List<Stock>
) : IPortfolio
