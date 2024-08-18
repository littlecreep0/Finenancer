package lc.wise.finenancer.data.api

import lc.wise.finenancer.domain.entity.CurrencyExchangeRate
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiCurrencyExchangeRate {
    @GET("/exrates/rates/{requestedCurrency}?parammode=2")
    suspend fun getExchangeRate(@Path("requestedCurrency") requestedCurrency: String):
        CurrencyExchangeRate
}
