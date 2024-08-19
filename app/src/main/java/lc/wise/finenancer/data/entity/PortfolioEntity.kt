package lc.wise.finenancer.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import lc.wise.finenancer.domain.entity.Asset

@Entity(
    tableName = "portfolio_list"
)
data class PortfolioEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "assets_list") val assetsList: List<Asset>
)
