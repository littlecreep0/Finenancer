package lc.wise.finenancer.presentation.utils

interface ViewType {
    fun type(typeFactory: TypeFactory): Int
}

sealed class AssetUI(
    open val id: Int,
    open val name: String,
    open val currency: String
) : ViewType {

    data class CashUI(
        override val id: Int,
        override val name: String,
        override val currency: String,
        val worth: Double
    ) : AssetUI(id, name, currency) {
        override fun type(typeFactory: TypeFactory) = typeFactory.type(this)
    }

    data class StockUI(
        override val id: Int,
        override val name: String,
        override val currency: String,
        val ticker: String,
        val country: String,
        val dividends: Double
    ) : AssetUI(id, name, currency) {
        override fun type(typeFactory: TypeFactory) = typeFactory.type(this)
    }

    data class BondUI(
        override val id: Int,
        override val name: String,
        override val currency: String,
        val ticker: String,
        val country: String,
        val fixedPayment: Double,
        val maturityDateDay: Int,
        val maturityDateMonth: Int,
        val maturityDateYear: Int
    ) : AssetUI(id, name, currency) {
        override fun type(typeFactory: TypeFactory) = typeFactory.type(this)
    }
}

enum class AssetClass {
    CASH,
    STOCK,
    BOND
}
