package lc.wise.finenancer.domain.repository

import lc.wise.finenancer.domain.entity.Currency

interface CurrencyRepository {
    fun getCurrencyByID(currencyID: Int): Currency?
    fun getAllCurrencies(): List<Currency>
    fun saveCurrency(currency: Currency): Currency?
    fun deleteCurrency(currencyID: Int)
}
