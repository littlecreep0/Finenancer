package lc.wise.finenancer.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "currencies_list"
)
data class CurrencyEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "currency_id") val currencyId: Int = 0,
    @ColumnInfo(name = "currency_name") val currencyName: String
)
