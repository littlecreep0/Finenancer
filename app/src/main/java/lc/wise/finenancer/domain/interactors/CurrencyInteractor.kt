package lc.wise.finenancer.domain.interactors

import javax.inject.Inject
import lc.wise.finenancer.domain.repository.CurrencyRepository

class CurrencyInteractor @Inject constructor(
    private val currencyRepository: CurrencyRepository
) {
    fun createCurrency() = currencyRepository.createCurrency()
    fun getCurrencyByID(currencyID: Int) = currencyRepository.getCurrencyByID(currencyID)
    fun getCurrencyList() = currencyRepository.getAllCurrencies()
    fun editCurrency(currencyID: Int) = currencyRepository.editCurrency(currencyID)
    fun deleteCurrency(currencyID: Int) = currencyRepository.deleteCurrency(currencyID)
}
