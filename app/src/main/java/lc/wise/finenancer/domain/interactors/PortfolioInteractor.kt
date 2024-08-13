package lc.wise.finenancer.domain.interactors

import javax.inject.Inject
import javax.inject.Singleton
import lc.wise.finenancer.domain.repository.PortfolioRepository

@Singleton
class PortfolioInteractor @Inject constructor(
    private val portfolioRepository: PortfolioRepository
) {
    fun createPortfolio() = portfolioRepository.createPortfolio()
    fun getPortfolioByID(portfolioID: Int) = portfolioRepository.getPortfolioByID(portfolioID)
    fun getPortfolioList() = portfolioRepository.getAllPortfolios()
    fun editPortfolio(portfolioID: Int) = portfolioRepository.editPortfolio(portfolioID)
    fun deletePortfolio(portfolioID: Int) = portfolioRepository.deletePortfolio(portfolioID)
}
