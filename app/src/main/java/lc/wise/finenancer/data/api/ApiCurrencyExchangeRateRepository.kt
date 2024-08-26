package lc.wise.finenancer.data.api

import java.util.concurrent.ConcurrentHashMap
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import lc.wise.finenancer.domain.entity.CurrencyExchangeRate
import lc.wise.finenancer.domain.repository.CurrencyExchangeRateRepository

class ApiCurrencyExchangeRateRepository @Inject constructor(
    private val service: ApiCurrencyExchangeRateService,
    private val mapper: ApiCurrencyExchangeRateMapper
) : CurrencyExchangeRateRepository {

    private val cache = ConcurrentHashMap<String, CurrencyExchangeRate>()

    override suspend fun getExchangeRate(requestedCurrency: String): CurrencyExchangeRate {
        return withContext(Dispatchers.IO) {
            cache[requestedCurrency] ?: run {
                val entity = service.getExchangeRate(requestedCurrency)
                val exchangeRate = mapper.fromEntity(entity)
                cache[requestedCurrency] = exchangeRate
                exchangeRate
            }
        }
    }
}
