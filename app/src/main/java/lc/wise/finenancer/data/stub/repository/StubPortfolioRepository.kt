package lc.wise.finenancer.data.stub.repository

import lc.wise.finenancer.data.stub.StubData
import lc.wise.finenancer.domain.entity.Portfolio
import lc.wise.finenancer.domain.repository.PortfolioRepository

class StubPortfolioRepository : PortfolioRepository {
    override fun createPortfolio() {}

    override fun getPortfolioByID(portfolioID: Int): Portfolio? =
        StubData.portfolioList.find { it.id == portfolioID }

    override fun getAllPortfolios(): List<Portfolio> =
        StubData.portfolioList
}
