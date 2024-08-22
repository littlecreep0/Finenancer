package lc.wise.finenancer.data.api

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.coroutines.withContext
import lc.wise.finenancer.domain.entity.CurrencyExchangeRate
import lc.wise.finenancer.domain.repository.CurrencyExchangeRateRepository
import java.util.concurrent.ConcurrentHashMap
import javax.inject.Inject

class ApiCurrencyExchangeRateRepository @Inject constructor(
    private val service: ApiCurrencyExchangeRateService,
    private val mapper: ApiCurrencyExchangeRateMapper
) : CurrencyExchangeRateRepository {

    private val cache = ConcurrentHashMap<String, CurrencyExchangeRate>()
    private val mutex = Mutex()

    override suspend fun getExchangeRate(requestedCurrency: String): CurrencyExchangeRate {
        return withContext(Dispatchers.IO) {
            mutex.withLock {
                cache[requestedCurrency] ?: run {
                    val entity = service.getExchangeRate(requestedCurrency)
                    val exchangeRate = mapper.fromEntity(entity)
                    cache[requestedCurrency] = exchangeRate
                    exchangeRate
                }
            }
        }
    }
}
