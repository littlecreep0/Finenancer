package lc.wise.finenancer.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "assets_list",
    foreignKeys = [
        ForeignKey(
            entity = PortfolioEntity::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("portfolio_id"),
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        )
    ],
    indices = [
        Index(value = ["portfolio_id"])
    ]
)
open class AssetEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") open val id: Int = 0,
    @ColumnInfo(name = "type") open val type: String,
    @ColumnInfo(name = "portfolio_id") open val portfolioId: Int?
)

@Entity(
    tableName = "cash_list",
    foreignKeys = [
        ForeignKey(
            entity = AssetEntity::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("id"),
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = CurrencyEntity::class,
            parentColumns = arrayOf("currency_id"),
            childColumns = arrayOf("currency_id"),
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        )
    ],
    indices = [
        Index(value = ["currency_id"])
    ]
)
data class CashEntity(
    @PrimaryKey
    @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "currency_id") val currencyId: Int,
    @ColumnInfo(name = "worth") val worth: Double
)

@Entity(
    tableName = "stocks_list",
    foreignKeys = [
        ForeignKey(
            entity = AssetEntity::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("id"),
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = CountryEntity::class,
            parentColumns = arrayOf("country_id"),
            childColumns = arrayOf("country_id"),
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = CurrencyEntity::class,
            parentColumns = arrayOf("currency_id"),
            childColumns = arrayOf("currency_id"),
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        )
    ],
    indices = [
        Index(value = ["country_id"]),
        Index(value = ["currency_id"])
    ]
)
data class StockEntity(
    @PrimaryKey
    @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "currency_id") val currencyId: Int,
    @ColumnInfo(name = "ticker") val ticker: String,
    @ColumnInfo(name = "country_id") val countryId: Int,
    @ColumnInfo(name = "dividends") val dividends: Double
)

@Entity(
    tableName = "bonds_list",
    foreignKeys = [
        ForeignKey(
            entity = AssetEntity::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("id"),
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = CountryEntity::class,
            parentColumns = arrayOf("country_id"),
            childColumns = arrayOf("country_id"),
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = CurrencyEntity::class,
            parentColumns = arrayOf("currency_id"),
            childColumns = arrayOf("currency_id"),
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        )
    ],
    indices = [
        Index(value = ["country_id"]),
        Index(value = ["currency_id"])
    ]
)
data class BondEntity(
    @PrimaryKey
    @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "currency_id") val currencyId: Int,
    @ColumnInfo(name = "ticker") val ticker: String,
    @ColumnInfo(name = "country_id") val countryId: Int,
    @ColumnInfo(name = "fixed_payment") val fixedPayment: Double,
    @ColumnInfo(name = "maturity_date_day") val maturityDateDay: Int,
    @ColumnInfo(name = "maturity_date_month") val maturityDateMonth: Int,
    @ColumnInfo(name = "maturity_date_year") val maturityDateYear: Int
)
