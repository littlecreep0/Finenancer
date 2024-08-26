package lc.wise.finenancer.data.stub.database

import javax.inject.Inject
import lc.wise.finenancer.data.dao.BondDao
import lc.wise.finenancer.data.dao.CashDao
import lc.wise.finenancer.data.dao.CountryDao
import lc.wise.finenancer.data.dao.CurrencyDao
import lc.wise.finenancer.data.dao.PortfolioDao
import lc.wise.finenancer.data.dao.StockDao
import lc.wise.finenancer.data.toBond
import lc.wise.finenancer.data.toCash
import lc.wise.finenancer.data.toCountry
import lc.wise.finenancer.data.toCurrency
import lc.wise.finenancer.data.toPortfolio
import lc.wise.finenancer.data.toPortfolioEntity
import lc.wise.finenancer.data.toStock
import lc.wise.finenancer.domain.entity.Asset
import lc.wise.finenancer.domain.entity.Portfolio
import lc.wise.finenancer.domain.repository.PortfolioRepository

class StubPortfolioEntity @Inject constructor(
    private val portfolioDao: PortfolioDao,
    private val cashDao: CashDao,
    private val stockDao: StockDao,
    private val bondDao: BondDao,
    private val currencyDao: CurrencyDao,
    private val countryDao: CountryDao
) : PortfolioRepository {

    override fun getPortfolioByID(portfolioID: Int): Portfolio =
        portfolioDao.getPortfolioById(portfolioID).toPortfolio(
            getAssetsListOfPortfolio(portfolioID)
        )

    override fun getAllPortfolios(): List<Portfolio> =
        portfolioDao.getPortfolioList().map { portfolioEntity ->
            portfolioEntity.toPortfolio(
                getAssetsListOfPortfolio(portfolioEntity.id)
            )
        }

    override fun savePortfolio(portfolio: Portfolio): Portfolio {
        portfolioDao.savePortfolio(portfolio.toPortfolioEntity())
        return portfolioDao.getPortfolioById(portfolio.id).toPortfolio(
            getAssetsListOfPortfolio(portfolio.id)
        )
    }

    override fun deletePortfolio(portfolioID: Int) = portfolioDao.deletePortfolio(
        portfolioDao.getPortfolioById(portfolioID)
    )

    private fun getAssetsListOfPortfolio(portfolioID: Int): List<Asset> =
        cashDao.getCashListByPortfolioID(portfolioID).map { cashEntity ->
            cashEntity.toCash(
                currencyDao.getCurrencyByID(
                    cashEntity.currencyId
                ).toCurrency()
            )
        } + stockDao.getStocksListByPortfolioID(portfolioID).map { stockEntity ->
            stockEntity.toStock(
                currencyDao.getCurrencyByID(
                    stockEntity.currencyId
                ).toCurrency(),
                countryDao.getCountryByID(
                    stockEntity.countryId
                ).toCountry()
            )
        } + bondDao.getBondsListByPortfolioID(portfolioID).map { bondEntity ->
            bondEntity.toBond(
                currencyDao.getCurrencyByID(
                    bondEntity.currencyId
                ).toCurrency(),
                countryDao.getCountryByID(
                    bondEntity.countryId
                ).toCountry()
            )
        }
}
