package lc.wise.finenancer.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import lc.wise.finenancer.data.api.ApiCurrencyExchangeRateService
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideExchangeRateApi(
        retrofit: Retrofit
    ): ApiCurrencyExchangeRateService {
        return retrofit.create(ApiCurrencyExchangeRateService::class.java)
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .build()
    }

    @Provides
    @Singleton
    fun provideConverterFactory(): retrofit2.Converter.Factory {
        return Json.asConverterFactory(
            "application/json; charset=utf8".toMediaType()
        )
    }

    @Provides
    @Singleton
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        converterFactory: retrofit2.Converter.Factory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.nbrb.by")
            .client(okHttpClient)
            .addConverterFactory(converterFactory)
            .build()
    }
}
