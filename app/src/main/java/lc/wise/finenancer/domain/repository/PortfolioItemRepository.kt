package lc.wise.finenancer.domain.repository

import lc.wise.finenancer.domain.entity.Cash
import lc.wise.finenancer.domain.entity.Stock

interface PortfolioItemRepository {
    fun createCash()
    fun getCashByID(cashID: Int): Cash?
    fun getAllCashes(): List<Cash>
//    fun updateCash(cashID: Int): Cash?
//    fun deleteCash(cashID: Int): Cash?

    fun createStock()
    fun getStockByID(stockID: Int): Stock?
    fun getAllStocks(): List<Stock>
//    fun updateStock(stockID: Int): Stock?
//    fun deleteStock(stockID: Int): Stock?
}
