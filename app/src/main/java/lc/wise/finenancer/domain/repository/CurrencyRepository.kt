package lc.wise.finenancer.domain.repository

import lc.wise.finenancer.domain.entity.Currency

interface CurrencyRepository {
    fun createCurrency()
    fun getCurrencyByID(currencyID: Int): Currency?
    fun getAllCurrencies(): List<Currency>
    fun updateCurrency(currencyID: Int): Currency?
    fun deleteCurrency(currencyID: Int): Currency?
}
