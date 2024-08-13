package lc.wise.finenancer.domain.repository

import lc.wise.finenancer.domain.entity.Portfolio

interface PortfolioRepository {
    fun createPortfolio(): Portfolio?
    fun getPortfolioByID(portfolioID: Int): Portfolio?
    fun getAllPortfolios(): List<Portfolio>
    fun editPortfolio(portfolioID: Int): Portfolio?
    fun deletePortfolio(portfolioID: Int)
}
