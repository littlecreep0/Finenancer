package lc.wise.finenancer.domain.interactors

import javax.inject.Inject
import lc.wise.finenancer.domain.entity.CurrencyExchangeRate
import lc.wise.finenancer.domain.repository.CurrencyExchangeRateRepository

class CurrencyExchangeRateInteractor @Inject constructor(
    private val currencyExchangeRateRepository: CurrencyExchangeRateRepository
) {

    suspend fun getExchangeRate(currency: String): CurrencyExchangeRate {
        return currencyExchangeRateRepository.getExchangeRate(currency)
    }

    suspend fun convertCurrency(amount: Double, fromCurrency: String, toCurrency: String): Double {
        val fromExchangeRate = currencyExchangeRateRepository.getExchangeRate(fromCurrency)
        val toExchangeRate = currencyExchangeRateRepository.getExchangeRate(toCurrency)
        return amount * (fromExchangeRate.rate / toExchangeRate.rate) *
            (toExchangeRate.scale / fromExchangeRate.scale)
    }
}
