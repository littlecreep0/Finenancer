package lc.wise.finenancer.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import lc.wise.finenancer.data.entity.BondEntity

@Dao
interface BondDao {
    @Query("SELECT * FROM bonds_list")
    fun getFullBondsList(): List<BondEntity>

    @Query(
        "SELECT * FROM bonds_list " +
            "INNER JOIN assets_list ON bonds_list.asset_id = assets_list.asset_id " +
            "WHERE portfolio_id = :portfolioID"
    )
    fun getBondsListByPortfolioID(portfolioID: Int): List<BondEntity>

    @Query("SELECT * FROM bonds_list WHERE asset_id = :bondID")
    fun getBondById(bondID: Int): BondEntity

    @Upsert
    fun saveBond(bondEntity: BondEntity)

    @Delete
    fun deleteBond(bondEntity: BondEntity)
}
