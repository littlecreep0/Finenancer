package lc.wise.finenancer.domain.repository

import lc.wise.finenancer.domain.entity.Currency

interface CurrencyRepository {
    fun createCurrency(): Currency?
    fun getCurrencyByID(currencyID: Int): Currency?
    fun getAllCurrencies(): List<Currency>
    fun editCurrency(currencyID: Int): Currency?
    fun deleteCurrency(currencyID: Int)
}
