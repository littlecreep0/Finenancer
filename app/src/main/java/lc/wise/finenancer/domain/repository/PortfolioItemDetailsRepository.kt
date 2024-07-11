package lc.wise.finenancer.domain.repository

import lc.wise.finenancer.domain.entity.CashDetails
import lc.wise.finenancer.domain.entity.StockDetails

interface IPortfolioItemDetailsRepository {
    fun getCashDetailsByID(cashDetailsID: Int): CashDetails?
    fun getAllCashDetails(): List<CashDetails>

    fun getStockDetailsByID(stockDetailsID: Int): StockDetails?
    fun getAllStockDetails(): List<StockDetails>
}
