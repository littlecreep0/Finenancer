package lc.wise.finenancer.domain.repository

import lc.wise.finenancer.data.StubData
import lc.wise.finenancer.domain.entities.Cash
import lc.wise.finenancer.domain.entities.Stock

interface PortfolioItemsRepositoryInterface {
    fun getCashByID(cashID: Int): Cash?
    fun getAllCashes(): MutableList<Cash>

    fun getStockByID(stockID: Int): Stock?
    fun getAllStocks(): MutableList<Stock>
}

class PortfolioItemsRepository: PortfolioItemsRepositoryInterface{
    override fun getCashByID(cashID: Int): Cash? {
        return StubData.portfolioCashList.find { it.id == cashID }
    }

    override fun getAllCashes(): MutableList<Cash> {
        return StubData.portfolioCashList
    }

    override fun getStockByID(stockID: Int): Stock? {
        return StubData.portfolioStockList.find { it.id == stockID }
    }

    override fun getAllStocks(): MutableList<Stock> {
        return StubData.portfolioStockList
    }
}
