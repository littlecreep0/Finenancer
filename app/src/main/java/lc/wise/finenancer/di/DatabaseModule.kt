package lc.wise.finenancer.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import lc.wise.finenancer.data.dao.AssetDao
import lc.wise.finenancer.data.dao.BondDao
import lc.wise.finenancer.data.dao.CashDao
import lc.wise.finenancer.data.dao.PortfolioDao
import lc.wise.finenancer.data.dao.StockDao
import lc.wise.finenancer.data.database.AppDatabase

@Module
@InstallIn(SingletonComponent::class)
interface DatabaseModule {
    @Provides
    @Singleton
    fun provideAppDatabase(
        @ApplicationContext context: Context
    ): AppDatabase = Room.databaseBuilder(
        context,
        AppDatabase::class.java,
        "finenancer_database"
    ).build()

    @Provides
    fun providePortfolioDao(
        appDatabase: AppDatabase
    ): PortfolioDao = appDatabase.portfolioDao()

    @Provides
    fun provideAssetDao(
        appDatabase: AppDatabase
    ): AssetDao = appDatabase.assetDao()

    @Provides
    fun provideCashDao(
        appDatabase: AppDatabase
    ): CashDao = appDatabase.cashDao()

    @Provides
    fun provideStockDao(
        appDatabase: AppDatabase
    ): StockDao = appDatabase.stockDao()

    @Provides
    fun provideBondDao(
        appDatabase: AppDatabase
    ): BondDao = appDatabase.bondDao()
}
