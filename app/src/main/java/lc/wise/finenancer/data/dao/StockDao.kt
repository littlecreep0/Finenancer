package lc.wise.finenancer.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import lc.wise.finenancer.domain.entity.Stock

@Dao
interface StockDao {
    @Query("SELECT * FROM stocks_list")
    fun getStocksList(): List<Stock>

    @Query("SELECT * FROM stocks_list WHERE id = :stockID")
    fun getStockById(stockID: Int): Stock?

    @Upsert
    fun saveStock(stock: Stock): Stock?

    @Delete
    fun deleteStock(stockID: Int)
}
