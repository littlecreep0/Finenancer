package lc.wise.finenancer.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import lc.wise.finenancer.data.stub.repository.StubAssetRepository
import lc.wise.finenancer.data.stub.repository.StubCurrencyRepository
import lc.wise.finenancer.data.stub.repository.StubPortfolioRepository
import lc.wise.finenancer.data.stub.repository.StubSettingStoreRepository
import lc.wise.finenancer.domain.repository.AssetRepository
import lc.wise.finenancer.domain.repository.CurrencyRepository
import lc.wise.finenancer.domain.repository.PortfolioRepository
import lc.wise.finenancer.domain.repository.SettingStoreRepository

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {
    @Binds
    @Singleton
    fun bindAssetRepository(
        repositoryImpl: StubAssetRepository
    ): AssetRepository

    @Binds
    @Singleton
    fun bindPortfolioRepository(
        repositoryImpl: StubPortfolioRepository
    ): PortfolioRepository

    @Binds
    @Singleton
    fun bindCurrencyRepository(
        repositoryImpl: StubCurrencyRepository
    ): CurrencyRepository

    @Binds
    @Singleton
    fun bindSettingStoreRepository(
        repositoryImpl: StubSettingStoreRepository
    ): SettingStoreRepository
}
