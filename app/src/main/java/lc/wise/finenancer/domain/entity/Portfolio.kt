package lc.wise.finenancer.domain.entity

data class Portfolio(
    val id: Int,
    val name: String,
    val assetsList: List<Asset>
)
