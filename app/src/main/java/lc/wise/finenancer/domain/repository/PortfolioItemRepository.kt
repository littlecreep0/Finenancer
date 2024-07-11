package lc.wise.finenancer.domain.repository

import lc.wise.finenancer.domain.entity.Cash
import lc.wise.finenancer.domain.entity.Stock

interface IPortfolioItemsRepository {
    fun getCashByID(cashID: Int): Cash?
    fun getAllCashes(): List<Cash>

    fun getStockByID(stockID: Int): Stock?
    fun getAllStocks(): List<Stock>
}
