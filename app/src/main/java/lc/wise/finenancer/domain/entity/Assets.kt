package lc.wise.finenancer.domain.entity

interface IAsset {
    val id: Int
    val name: String
    val totalAmount: Double
}

data class Asset(
    override val id: Int,
    override val name: String,
    override val totalAmount: Double
) : IAsset
