package lc.wise.finenancer.domain.entity

data class CurrencyExchangeRate(
    val id: Int,
    val date: String,
    val abbreviation: String,
    val name: String,
    val scale: Int,
    val rate: Double
)
