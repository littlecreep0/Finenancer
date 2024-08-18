package lc.wise.finenancer.domain.interactors

import javax.inject.Inject
import lc.wise.finenancer.domain.entity.Currency
import lc.wise.finenancer.domain.repository.CurrencyRepository

class CurrencyInteractor @Inject constructor(
    private val currencyRepository: CurrencyRepository
) {
    fun getCurrencyByID(currencyID: Int) = currencyRepository.getCurrencyByID(currencyID)
    fun getCurrencyList() = currencyRepository.getAllCurrencies()
    fun saveCurrency(currency: Currency) = currencyRepository.saveCurrency(currency)
    fun deleteCurrency(currencyID: Int) = currencyRepository.deleteCurrency(currencyID)
}
