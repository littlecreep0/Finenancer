package lc.wise.finenancer.data.stub.repository

import lc.wise.finenancer.data.stub.StubData
import lc.wise.finenancer.domain.entity.Currency
import lc.wise.finenancer.domain.repository.ICurrencyRepository

class StubCurrencyRepository : ICurrencyRepository {
    override fun getCurrencyByID(currencyID: Int): Currency? {
        return StubData.currencyList.find { it.id == currencyID }
    }

    override fun getAllCurrencies(): List<Currency> {
        return StubData.currencyList
    }
}
