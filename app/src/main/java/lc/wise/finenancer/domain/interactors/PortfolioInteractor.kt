package lc.wise.finenancer.domain.interactors

import javax.inject.Inject
import javax.inject.Singleton
import lc.wise.finenancer.domain.entity.Portfolio
import lc.wise.finenancer.domain.repository.PortfolioRepository

@Singleton
class PortfolioInteractor @Inject constructor(
    private val portfolioRepository: PortfolioRepository
) {
    fun getPortfolioByID(portfolioID: Int) = portfolioRepository.getPortfolioByID(portfolioID)
    fun getPortfolioList() = portfolioRepository.getAllPortfolios()
    fun savePortfolio(portfolio: Portfolio) = portfolioRepository.savePortfolio(portfolio)
    fun deletePortfolio(portfolioID: Int) = portfolioRepository.deletePortfolio(portfolioID)
}
