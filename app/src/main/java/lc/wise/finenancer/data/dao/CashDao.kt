package lc.wise.finenancer.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import lc.wise.finenancer.domain.entity.Cash

@Dao
interface CashDao {
    @Query("SELECT * FROM cash_list")
    fun getCashList(): List<Cash>

    @Query("SELECT * FROM cash_list WHERE id = :cashID")
    fun getCashById(cashID: Int): Cash?

    @Upsert
    fun saveCash(cash: Cash): Cash?

    @Delete
    fun deleteCash(cashID: Int)
}
