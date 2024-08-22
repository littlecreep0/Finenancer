package lc.wise.finenancer.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import lc.wise.finenancer.data.entity.PortfolioEntity

@Dao
interface PortfolioDao {
    @Query("SELECT * FROM portfolio_list")
    fun getPortfolioList(): List<PortfolioEntity>

    @Query("SELECT * FROM portfolio_list WHERE portfolio_id = :portfolioID")
    fun getPortfolioById(portfolioID: Int): PortfolioEntity

    @Upsert
    fun savePortfolio(portfolioEntity: PortfolioEntity)

    @Delete
    fun deletePortfolio(portfolioEntity: PortfolioEntity)
}
