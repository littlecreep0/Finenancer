package lc.wise.finenancer.domain.repository

import lc.wise.finenancer.domain.entity.Portfolio

interface PortfolioRepository {
    fun getPortfolioByID(portfolioID: Int): Portfolio?
    fun getAllPortfolios(): List<Portfolio>
    fun savePortfolio(portfolio: Portfolio): Portfolio?
    fun deletePortfolio(portfolioID: Int)
}
