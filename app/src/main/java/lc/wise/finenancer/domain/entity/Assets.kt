package lc.wise.finenancer.domain.entity

import java.time.LocalDate

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
    val country: String,
    val dividends: Double
) : Asset(id, name, currency)

data class Bond(
    override val id: Int,
    override val name: String,
    override val currency: Currency,
    val ticker: String,
    val country: String,
    val fixedPayment: Double,
    val maturityDate: LocalDate
) : Asset(id, name, currency)
