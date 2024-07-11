package lc.wise.finenancer.data.stub.repository

import lc.wise.finenancer.data.stub.StubData
import lc.wise.finenancer.domain.entity.Currency
import lc.wise.finenancer.domain.repository.CurrencyRepository

class StubCurrencyRepository : CurrencyRepository {
    override fun createCurrency() {}

    override fun getCurrencyByID(currencyID: Int): Currency? =
        StubData.currencyList.find { it.id == currencyID }

    override fun getAllCurrencies(): List<Currency> =
        StubData.currencyList
}
