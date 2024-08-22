package lc.wise.finenancer.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import lc.wise.finenancer.data.entity.CurrencyEntity

@Dao
interface CurrencyDao {
    @Query("SELECT * FROM currencies_list")
    fun getCurrenciesList(): List<CurrencyEntity>

    @Query("SELECT * FROM currencies_list WHERE currency_id = :currencyID")
    fun getCurrencyByID(currencyID: Int): CurrencyEntity

    @Upsert
    fun saveCurrency(currencyEntity: CurrencyEntity)

    @Delete
    fun deleteCurrency(currencyEntity: CurrencyEntity)
}
