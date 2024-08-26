package lc.wise.finenancer.data.api

import retrofit2.http.GET
import retrofit2.http.Path

interface ApiCurrencyExchangeRateService {
    @GET("/exrates/rates/{requestedCurrency}?parammode=2")
    suspend fun getExchangeRate(@Path("requestedCurrency") requestedCurrency: String):
        ApiCurrencyExchangeRateEntity
}
