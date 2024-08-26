package lc.wise.finenancer.domain.repository

import lc.wise.finenancer.domain.entity.CurrencyExchangeRate

interface CurrencyExchangeRateRepository {
    suspend fun getExchangeRate(requestedCurrency: String): CurrencyExchangeRate
}
