package lc.wise.finenancer.data.stub.repository

import lc.wise.finenancer.data.stub.StubData
import lc.wise.finenancer.domain.entity.CashDetails
import lc.wise.finenancer.domain.entity.StockDetails
import lc.wise.finenancer.domain.repository.IPortfolioItemDetailsRepository

class StubPortfolioItemDetailsRepository : IPortfolioItemDetailsRepository {
    override fun getCashDetailsByID(cashDetailsID: Int): CashDetails? {
        return StubData.CashDetailsList.find { it.id == cashDetailsID }
    }

    override fun getAllCashDetails(): List<CashDetails> {
        return StubData.CashDetailsList
    }

    override fun getStockDetailsByID(stockDetailsID: Int): StockDetails? {
        return StubData.StockDetailsList.find { it.id == stockDetailsID }
    }

    override fun getAllStockDetails(): List<StockDetails> {
        return StubData.StockDetailsList
    }
}
