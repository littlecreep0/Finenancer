package lc.wise.finenancer.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "portfolio_list"
)
data class PortfolioEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "portfolio_id") val portfolioId: Int = 0,
    @ColumnInfo(name = "portfolio_name") val portfolioName: String
)
