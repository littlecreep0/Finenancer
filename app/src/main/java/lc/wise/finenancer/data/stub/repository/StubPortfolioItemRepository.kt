package lc.wise.finenancer.data.stub.repository

import lc.wise.finenancer.data.stub.StubData
import lc.wise.finenancer.domain.entity.Cash
import lc.wise.finenancer.domain.entity.Stock
import lc.wise.finenancer.domain.repository.IPortfolioItemsRepository

class PortfolioItemsRepository : IPortfolioItemsRepository {
    override fun getCashByID(cashID: Int): Cash? {
        return StubData.portfolioCashList.find { it.id == cashID }
    }

    override fun getAllCashes(): List<Cash> {
        return StubData.portfolioCashList
    }

    override fun getStockByID(stockID: Int): Stock? {
        return StubData.portfolioStockList.find { it.id == stockID }
    }

    override fun getAllStocks(): List<Stock> {
        return StubData.portfolioStockList
    }
}
