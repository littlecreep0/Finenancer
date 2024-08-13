package lc.wise.finenancer.domain.entity

interface ICurrency {
    val currencyName: String
}

enum class Currency(
    override val currencyName: String
) : ICurrency {
    USD("USD"),
    EUR("EUR"),
    BYN("BYN"),
    RUB("RUB"),
    CNY("CNY"),
}
