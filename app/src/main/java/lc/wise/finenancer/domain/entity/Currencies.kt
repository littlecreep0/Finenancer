package lc.wise.finenancer.domain.entity

interface ICurrency {
    val id: Int
    val name: String
}

data class Currency(
    override val id: Int,
    override val name: String,
) : ICurrency
