package lc.wise.finenancer.domain.repository

import lc.wise.finenancer.data.StubData
import lc.wise.finenancer.domain.entities.Currency

interface CurrencyRepositoryInterface {
    fun getCurrencyByID(currencyID: Int): Currency?
    fun getAllCurrencies(): MutableList<Currency>
}

class CurrencyRepository : CurrencyRepositoryInterface {
    override fun getCurrencyByID(currencyID: Int): Currency? {
        return StubData.currencyList.find { it.id == currencyID }
    }

    override fun getAllCurrencies(): MutableList<Currency> {
        return StubData.currencyList
    }
}
