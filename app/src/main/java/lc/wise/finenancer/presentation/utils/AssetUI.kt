package lc.wise.finenancer.presentation.utils

interface ViewType {
    fun type(typeFactory: TypeFactory): Int
}

sealed class AssetUI(
    open val assetId: Int,
    open val assetName: String,
    open val currency: String
) : ViewType {

    data class CashUI(
        override val assetId: Int,
        override val assetName: String,
        override val currency: String,
        val worth: Double
    ) : AssetUI(assetId, assetName, currency) {
        override fun type(typeFactory: TypeFactory) = typeFactory.type(this)
    }

    data class StockUI(
        override val assetId: Int,
        override val assetName: String,
        override val currency: String,
        val ticker: String,
        val country: String,
        val dividends: Double
    ) : AssetUI(assetId, assetName, currency) {
        override fun type(typeFactory: TypeFactory) = typeFactory.type(this)
    }

    data class BondUI(
        override val assetId: Int,
        override val assetName: String,
        override val currency: String,
        val ticker: String,
        val country: String,
        val fixedPayment: Double,
        val maturityDateDay: Int,
        val maturityDateMonth: Int,
        val maturityDateYear: Int
    ) : AssetUI(assetId, assetName, currency) {
        override fun type(typeFactory: TypeFactory) = typeFactory.type(this)
    }
}
