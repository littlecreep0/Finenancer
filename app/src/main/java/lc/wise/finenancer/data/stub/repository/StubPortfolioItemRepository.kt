package lc.wise.finenancer.data.stub.repository

import javax.inject.Inject
import lc.wise.finenancer.data.stub.StubData
import lc.wise.finenancer.domain.entity.Cash
import lc.wise.finenancer.domain.entity.Stock
import lc.wise.finenancer.domain.repository.PortfolioItemRepository

class StubPortfolioItemRepository @Inject constructor() : PortfolioItemRepository {
    override fun createCash() {}

    override fun getCashByID(cashID: Int): Cash? =
        StubData.portfolioCashList.find { it.id == cashID }

    override fun getAllCashes(): List<Cash> =
        StubData.portfolioCashList

    override fun createStock() {}

    override fun getStockByID(stockID: Int): Stock? =
        StubData.portfolioStockList.find { it.id == stockID }

    override fun getAllStocks(): List<Stock> =
        StubData.portfolioStockList
}
