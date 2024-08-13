package lc.wise.finenancer.data.stub.repository

import javax.inject.Inject
import lc.wise.finenancer.data.stub.StubData
import lc.wise.finenancer.domain.entity.Portfolio
import lc.wise.finenancer.domain.repository.PortfolioRepository

class StubPortfolioRepository @Inject constructor() : PortfolioRepository {
    override fun createPortfolio(): Portfolio? {
        TODO()
    }

    override fun getPortfolioByID(portfolioID: Int): Portfolio? =
        StubData.portfolioList.find { it.id == portfolioID }

    override fun getAllPortfolios(): List<Portfolio> =
        StubData.portfolioList

    override fun editPortfolio(portfolioID: Int): Portfolio? {
        TODO()
    }

    override fun deletePortfolio(portfolioID: Int) {
        TODO()
    }
}
