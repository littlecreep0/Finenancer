package lc.wise.finenancer.data.api

import lc.wise.finenancer.domain.entity.CurrencyExchangeRate
import lc.wise.finenancer.domain.repository.CurrencyExchangeRateRepository
import javax.inject.Inject

class ApiCurrencyExchangeRateRepository @Inject constructor(
    private val exchangeRateApi: ApiCurrencyExchangeRate
) : CurrencyExchangeRateRepository {
    override suspend fun getExchangeRate(requestedCurrency: String): CurrencyExchangeRate {
        return exchangeRateApi.getExchangeRate(requestedCurrency)
    }
}
