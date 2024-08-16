package lc.wise.finenancer.domain.entity

import java.time.LocalDate

data class Country(
    val id: Int,
    val name: String
)

open class Asset(
    open val id: Int,
    open val name: String,
    open val currency: Currency
)

data class Cash(
    override val id: Int,
    override val name: String,
    override val currency: Currency,
    val worth: Double
) : Asset(id, name, currency)

data class Stock(
    override val id: Int,
    override val name: String,
    override val currency: Currency,
    val ticker: String,
    val country: Country,
    val dividends: Double
) : Asset(id, name, currency)

data class Bond(
    override val id: Int,
    override val name: String,
    override val currency: Currency,
    val ticker: String,
    val country: Country,
    val fixedPayment: Double,
    val maturityDate: LocalDate
) : Asset(id, name, currency)
