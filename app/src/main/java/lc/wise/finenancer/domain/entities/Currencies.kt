package lc.wise.finenancer.domain.entities

interface CurrencyInterface {
    val id: Int
    val name: String
}

data class Currency(
    override val id: Int,
    override val name: String,
) : CurrencyInterface
