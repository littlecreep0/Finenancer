package lc.wise.finenancer.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import lc.wise.finenancer.data.dao.AssetDao
import lc.wise.finenancer.data.dao.BondDao
import lc.wise.finenancer.data.dao.CashDao
import lc.wise.finenancer.data.dao.CountryDao
import lc.wise.finenancer.data.dao.CurrencyDao
import lc.wise.finenancer.data.dao.PortfolioDao
import lc.wise.finenancer.data.dao.StockDao
import lc.wise.finenancer.data.entity.AssetEntity
import lc.wise.finenancer.data.entity.BondEntity
import lc.wise.finenancer.data.entity.CashEntity
import lc.wise.finenancer.data.entity.CountryEntity
import lc.wise.finenancer.data.entity.CurrencyEntity
import lc.wise.finenancer.data.entity.PortfolioEntity
import lc.wise.finenancer.data.entity.StockEntity

@Database(
    entities = [
        PortfolioEntity::class,
        AssetEntity::class,
        CashEntity::class,
        StockEntity::class,
        BondEntity::class,
        CountryEntity::class,
        CurrencyEntity::class
    ],
    version = 1,
    exportSchema = true
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun portfolioDao(): PortfolioDao
    abstract fun assetDao(): AssetDao
    abstract fun cashDao(): CashDao
    abstract fun stockDao(): StockDao
    abstract fun bondDao(): BondDao
    abstract fun countryDao(): CountryDao
    abstract fun currencyDao(): CurrencyDao
}
