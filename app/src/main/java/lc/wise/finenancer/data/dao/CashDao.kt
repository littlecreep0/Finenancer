package lc.wise.finenancer.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import lc.wise.finenancer.data.entity.CashEntity

@Dao
interface CashDao {
    @Query("SELECT * FROM cash_list")
    fun getFullCashList(): List<CashEntity>

    @Query(
        "SELECT * FROM cash_list " +
            "INNER JOIN assets_list ON cash_list.id = assets_list.id " +
            "WHERE portfolio_id = :portfolioID"
    )
    fun getCashListByPortfolioID(portfolioID: Int): List<CashEntity>

    @Query("SELECT * FROM cash_list WHERE id = :cashID")
    fun getCashById(cashID: Int): CashEntity

    @Upsert
    fun saveCash(cashEntity: CashEntity)

    @Delete
    fun deleteCash(cashEntity: CashEntity)
}
