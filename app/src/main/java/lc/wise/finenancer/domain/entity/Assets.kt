package lc.wise.finenancer.domain.entity

import java.time.LocalDate
import lc.wise.finenancer.presentation.utils.TypeFactory

interface AssetType {
    fun type(typeFactory: TypeFactory): Int
}

data class Country(
    val id: Int,
    val name: String
)

abstract class Asset(
    open val id: Int,
    open val name: String,
    open val currency: Currency
) : AssetType

data class Cash(
    override val id: Int,
    override val name: String,
    override val currency: Currency,
    val worth: Double
) : Asset(id, name, currency) {
    override fun type(typeFactory: TypeFactory) = typeFactory.type(this)
}

data class Stock(
    override val id: Int,
    override val name: String,
    override val currency: Currency,
    val ticker: String,
    val country: Country,
    val dividends: Double
) : Asset(id, name, currency) {
    override fun type(typeFactory: TypeFactory) = typeFactory.type(this)
}

data class Bond(
    override val id: Int,
    override val name: String,
    override val currency: Currency,
    val ticker: String,
    val country: Country,
    val fixedPayment: Double,
    val maturityDate: LocalDate
) : Asset(id, name, currency) {
    override fun type(typeFactory: TypeFactory) = typeFactory.type(this)
}
