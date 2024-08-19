package lc.wise.finenancer.data.stub.database

import lc.wise.finenancer.data.dao.PortfolioDao
import lc.wise.finenancer.domain.entity.Portfolio
import lc.wise.finenancer.domain.repository.PortfolioRepository
import javax.inject.Inject
import kotlin.random.Random

class StubPortfolioEntity @Inject constructor(
    private val portfolioDao: PortfolioDao
) : PortfolioRepository {

    override fun getPortfolioByID(portfolioID: Int): Portfolio? =
        portfolioDao.getPortfolioById(portfolioID)

    override fun getAllPortfolios(): List<Portfolio> = portfolioDao.getPortfolioList()

    override fun savePortfolio(portfolio: Portfolio): Portfolio? {
        val randomID = Random.nextInt()
        return portfolioDao.savePortfolio(
            Portfolio(
                randomID,
                "My Portfolio $randomID", // written in a separate dialog by user
                emptyList()
            )
        )
    }

    override fun deletePortfolio(portfolioID: Int) = portfolioDao.deletePortfolio(portfolioID)
}
