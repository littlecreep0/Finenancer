package lc.wise.finenancer.domain.repository

import lc.wise.finenancer.domain.entity.Currency

interface ICurrencyRepository {
    fun getCurrencyByID(currencyID: Int): Currency?
    fun getAllCurrencies(): List<Currency>
}
