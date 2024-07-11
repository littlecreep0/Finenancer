package lc.wise.finenancer.domain.repository

import lc.wise.finenancer.domain.entity.CashDetails
import lc.wise.finenancer.domain.entity.StockDetails

interface PortfolioItemDetailsRepository {
    fun createCashDetails()
    fun getCashDetailsByID(cashDetailsID: Int): CashDetails?
    fun getAllCashDetails(): List<CashDetails>
    fun updateCashDetails(cashDetailsID: Int): CashDetails?
    fun deleteCashDetails(cashDetailsID: Int): CashDetails?

    fun createStockDetails()
    fun getStockDetailsByID(stockDetailsID: Int): StockDetails?
    fun getAllStockDetails(): List<StockDetails>
    fun updateStockDetails(stockDetailsID: Int): StockDetails?
    fun deleteStockDetails(stockDetailsID: Int): StockDetails?
}
