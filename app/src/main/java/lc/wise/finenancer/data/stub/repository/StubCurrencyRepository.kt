package lc.wise.finenancer.data.stub.repository

import javax.inject.Inject
import lc.wise.finenancer.data.stub.StubData
import lc.wise.finenancer.domain.entity.Currency
import lc.wise.finenancer.domain.repository.CurrencyRepository

class StubCurrencyRepository @Inject constructor() : CurrencyRepository {

    override suspend fun createCurrency() {}

    override suspend fun getCurrencyByID(currencyID: Int): Currency? =
        StubData.currencyList.find { it.id == currencyID }

    override suspend fun getAllCurrencies(): List<Currency> =
        StubData.currencyList

    override fun saveCurrency(currency: Currency): Currency? {
        TODO()
    }

    override fun deleteCurrency(currencyID: Int) {
        TODO()
    }
}
