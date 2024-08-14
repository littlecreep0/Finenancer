package lc.wise.finenancer.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import lc.wise.finenancer.data.stub.repository.StubAssetRepository
import lc.wise.finenancer.data.stub.repository.StubCurrencyRepository
import lc.wise.finenancer.data.stub.repository.StubPortfolioItemDetailsRepository
import lc.wise.finenancer.data.stub.repository.StubPortfolioItemRepository
import lc.wise.finenancer.data.stub.repository.StubPortfolioRepository
import lc.wise.finenancer.data.stub.repository.StubSettingStoreRepository
import lc.wise.finenancer.domain.repository.AssetRepository
import lc.wise.finenancer.domain.repository.CurrencyRepository
import lc.wise.finenancer.domain.repository.PortfolioItemDetailsRepository
import lc.wise.finenancer.domain.repository.PortfolioItemRepository
import lc.wise.finenancer.domain.repository.PortfolioRepository
import lc.wise.finenancer.domain.repository.SettingStoreRepository
import javax.inject.Singleton

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

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
    fun bindCurrencyRepository(
        repositoryImpl: StubCurrencyRepository
    ): CurrencyRepository

    @Binds
    @Singleton
    fun bindPortfolioItemDetailsRepository(
        repositoryImpl: StubPortfolioItemDetailsRepository
    ): PortfolioItemDetailsRepository

    @Binds
    @Singleton
    fun bindPortfolioItemsRepository(
        repositoryImpl: StubPortfolioItemRepository
    ): PortfolioItemRepository

    @Binds
    @Singleton
    fun bindPortfolioRepository(
        repositoryImpl: StubPortfolioRepository
    ): PortfolioRepository

    @Binds
    @Singleton
    fun bindSettingStoreRepository(
        repositoryImpl: StubSettingStoreRepository
    ): SettingStoreRepository
}

@Module
@InstallIn(SingletonComponent::class)
object DataStoreModule {
    @Provides
    @Singleton
    fun provideDataStore(@ApplicationContext context: Context): DataStore<Preferences> {
        return context.dataStore
    }
}
