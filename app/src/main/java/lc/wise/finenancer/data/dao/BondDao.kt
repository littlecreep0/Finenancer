package lc.wise.finenancer.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import lc.wise.finenancer.domain.entity.Asset.Bond

@Dao
interface BondDao {
    @Query("SELECT * FROM bonds_list")
    fun getBondsList(): List<Bond>

    @Query("SELECT * FROM bonds_list WHERE id = :bondID")
    fun getBondById(bondID: Int): Bond?

    @Upsert
    fun saveBond(bond: Bond): Bond?

    @Delete
    fun deleteBond(bondID: Int)
}
