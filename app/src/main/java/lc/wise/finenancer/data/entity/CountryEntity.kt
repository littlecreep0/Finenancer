package lc.wise.finenancer.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "countries_list"
)
data class CountryEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "country_id") val countryId: Int = 0,
    @ColumnInfo(name = "country_name") val countryName: String
)
