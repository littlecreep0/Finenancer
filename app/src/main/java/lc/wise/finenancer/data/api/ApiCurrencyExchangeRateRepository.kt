package lc.wise.finenancer.data.api

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import lc.wise.finenancer.domain.entity.CurrencyExchangeRate
import lc.wise.finenancer.domain.repository.CurrencyExchangeRateRepository
import javax.inject.Inject

class ApiCurrencyExchangeRateRepository @Inject constructor(
    private val service: ApiCurrencyExchangeRateService,
    private val mapper: ApiCurrencyExchangeRateMapper
) : CurrencyExchangeRateRepository {
    override suspend fun getExchangeRate(requestedCurrency: String): CurrencyExchangeRate {
        return withContext(Dispatchers.IO) {
            val entity = service.getExchangeRate(requestedCurrency)
            mapper.fromEntity(entity)
        }
    }
}
