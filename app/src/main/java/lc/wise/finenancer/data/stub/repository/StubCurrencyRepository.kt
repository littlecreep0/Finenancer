package lc.wise.finenancer.data.stub.repository

import javax.inject.Inject
import lc.wise.finenancer.data.stub.StubData
import lc.wise.finenancer.domain.entity.Currency
import lc.wise.finenancer.domain.repository.CurrencyRepository

class StubCurrencyRepository @Inject constructor() : CurrencyRepository {
    override fun createCurrency(): Currency? {
        TODO()
    }

    override fun getCurrencyByID(currencyID: Int): Currency? =
        StubData.currencyList.find { it.id == currencyID }

    override fun getAllCurrencies(): List<Currency> =
        StubData.currencyList

    override fun editCurrency(currencyID: Int): Currency? {
        TODO()
    }

    override fun deleteCurrency(currencyID: Int) {
        TODO()
    }
}
