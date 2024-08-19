package lc.wise.finenancer.data.entity

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Ignore
import androidx.room.PrimaryKey
import java.time.LocalDate
import lc.wise.finenancer.domain.entity.Country
import lc.wise.finenancer.domain.entity.Currency

@Entity(
    tableName = "assets_list"
)
open class AssetEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") open val id: Int,
    @ColumnInfo(name = "type") open val type: String,
    @Ignore open val name: String,
    @Ignore open val currency: Currency
)

@Entity(
    tableName = "cash_list",
    foreignKeys = [
        ForeignKey(
            entity = AssetEntity::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("id"),
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class CashEntity(
    @PrimaryKey
    @ColumnInfo(name = "id") override val id: Int,
    @Ignore override val type: String,
    @ColumnInfo(name = "name") override val name: String,
    @Embedded
    @ColumnInfo(name = "currency") override val currency: Currency,
    @ColumnInfo(name = "worth") val worth: Double
) : AssetEntity(id, type, name, currency)

@Entity(
    tableName = "stocks_list",
    foreignKeys = [
        ForeignKey(
            entity = AssetEntity::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("id"),
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class StockEntity(
    @PrimaryKey
    @ColumnInfo(name = "id") override val id: Int,
    @Ignore override val type: String,
    @ColumnInfo(name = "name") override val name: String,
    @Embedded
    @ColumnInfo(name = "currency") override val currency: Currency,
    @ColumnInfo(name = "ticker") val ticker: String,
    @Embedded
    @ColumnInfo(name = "country") val country: Country,
    @ColumnInfo(name = "dividends") val dividends: Double
) : AssetEntity(id, type, name, currency)

@Entity(
    tableName = "bonds_list",
    foreignKeys = [
        ForeignKey(
            entity = AssetEntity::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("id"),
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        )
    ]
)
data class BondEntity(
    @PrimaryKey
    @ColumnInfo(name = "id") override val id: Int,
    @Ignore override val type: String,
    @ColumnInfo(name = "name") override val name: String,
    @Embedded
    @ColumnInfo(name = "currency") override val currency: Currency,
    @ColumnInfo(name = "ticker") val ticker: String,
    @Embedded
    @ColumnInfo(name = "country") val country: Country,
    @ColumnInfo(name = "fixed_payment") val fixedPayment: Double,
    @Embedded
    @ColumnInfo(name = "maturity_date") val maturityDate: LocalDate
) : AssetEntity(id, type, name, currency)
