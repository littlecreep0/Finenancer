package lc.wise.finenancer.domain.repository

import lc.wise.finenancer.domain.entity.Currency

interface CurrencyRepository {
    suspend fun createCurrency()
    suspend fun getCurrencyByID(currencyID: Int): Currency?
    suspend fun getAllCurrencies(): List<Currency>
//    fun updateCurrency(currencyID: Int): Currency?
//    fun deleteCurrency(currencyID: Int): Currency?
}
