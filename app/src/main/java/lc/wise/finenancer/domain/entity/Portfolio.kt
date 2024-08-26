package lc.wise.finenancer.domain.entity

data class Portfolio(
    val portfolioId: Int,
    val portfolioName: String,
    val assetsList: List<Asset>
)
