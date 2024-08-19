package lc.wise.finenancer.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import lc.wise.finenancer.domain.entity.Portfolio

@Dao
interface PortfolioDao {
    @Query("SELECT * FROM portfolio_list")
    fun getPortfolioList(): List<Portfolio>

    @Query("SELECT * FROM portfolio_list WHERE id = :portfolioID")
    fun getPortfolioById(portfolioID: Int): Portfolio?

    @Upsert
    fun savePortfolio(portfolio: Portfolio): Portfolio?

    @Delete
    fun deletePortfolio(portfolioID: Int)
}
