package lc.wise.finenancer.data.stub.repository

import javax.inject.Inject
import lc.wise.finenancer.data.stub.StubData
import lc.wise.finenancer.domain.entity.CashDetails
import lc.wise.finenancer.domain.entity.StockDetails
import lc.wise.finenancer.domain.repository.PortfolioItemDetailsRepository

class StubPortfolioItemDetailsRepository @Inject constructor() : PortfolioItemDetailsRepository {
    override fun createCashDetails() {}

    override fun getCashDetailsByID(cashDetailsID: Int): CashDetails? =
        StubData.CashDetailsList.find { it.id == cashDetailsID }

    override fun getAllCashDetails(): List<CashDetails> =
        StubData.CashDetailsList

    override fun createStockDetails() {}

    override fun getStockDetailsByID(stockDetailsID: Int): StockDetails? =
        StubData.StockDetailsList.find { it.id == stockDetailsID }

    override fun getAllStockDetails(): List<StockDetails> =
        StubData.StockDetailsList
}
