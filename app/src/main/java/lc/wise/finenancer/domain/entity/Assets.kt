package lc.wise.finenancer.domain.entity

import java.time.LocalDate

data class Country(
    val countryId: Int,
    val countryName: String
)

sealed class Asset(
    open val assetId: Int,
    open val assetName: String,
    open val currency: Currency
) {

    data class Cash(
        override val assetId: Int,
        override val assetName: String,
        override val currency: Currency,
        val worth: Double
    ) : Asset(assetId, assetName, currency)

    data class Stock(
        override val assetId: Int,
        override val assetName: String,
        override val currency: Currency,
        val ticker: String,
        val country: Country,
        val dividends: Double
    ) : Asset(assetId, assetName, currency)

    data class Bond(
        override val assetId: Int,
        override val assetName: String,
        override val currency: Currency,
        val ticker: String,
        val country: Country,
        val fixedPayment: Double,
        val maturityDate: LocalDate
    ) : Asset(assetId, assetName, currency)
}
