package lc.wise.finenancer.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import lc.wise.finenancer.data.entity.StockEntity

@Dao
interface StockDao {
    @Query("SELECT * FROM stocks_list")
    fun getFullStocksList(): List<StockEntity>

    @Query(
        "SELECT * FROM stocks_list " +
            "INNER JOIN assets_list ON stocks_list.id = assets_list.id " +
            "WHERE portfolio_id = :portfolioID"
    )
    fun getStocksListByPortfolioID(portfolioID: Int): List<StockEntity>

    @Query("SELECT * FROM stocks_list WHERE id = :stockID")
    fun getStockById(stockID: Int): StockEntity

    @Upsert
    fun saveStock(stockEntity: StockEntity)

    @Delete
    fun deleteStock(stockEntity: StockEntity)
}
