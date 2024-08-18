package lc.wise.finenancer.domain.interactors

import lc.wise.finenancer.domain.entity.CurrencyExchangeRate
import lc.wise.finenancer.domain.repository.CurrencyExchangeRateRepository
import javax.inject.Inject

class CurrencyExchangeRateInteractor @Inject constructor(
    private val exchangeRateRepository: CurrencyExchangeRateRepository
) {

    suspend fun getExchangeRate(currency: String): CurrencyExchangeRate {
        return exchangeRateRepository.getExchangeRate(currency)
    }

    suspend fun convertCurrency(amount: Double, fromCurrency: String, toCurrency: String): Double {
        val fromExchangeRate = exchangeRateRepository.getExchangeRate(fromCurrency)
        val toExchangeRate = exchangeRateRepository.getExchangeRate(toCurrency)
        return amount * (fromExchangeRate.rate / toExchangeRate.rate) *
            (toExchangeRate.scale / fromExchangeRate.scale)
    }
}
