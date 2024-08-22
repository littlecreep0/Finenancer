package lc.wise.finenancer.data.stub.database

import javax.inject.Inject
import lc.wise.finenancer.data.dao.AssetDao
import lc.wise.finenancer.data.dao.BondDao
import lc.wise.finenancer.data.dao.CashDao
import lc.wise.finenancer.data.dao.CountryDao
import lc.wise.finenancer.data.dao.CurrencyDao
import lc.wise.finenancer.data.dao.StockDao
import lc.wise.finenancer.data.toBond
import lc.wise.finenancer.data.toBondEntity
import lc.wise.finenancer.data.toCash
import lc.wise.finenancer.data.toCashEntity
import lc.wise.finenancer.data.toCountry
import lc.wise.finenancer.data.toCurrency
import lc.wise.finenancer.data.toStock
import lc.wise.finenancer.data.toStockEntity
import lc.wise.finenancer.domain.entity.Asset
import lc.wise.finenancer.domain.entity.Asset.Bond
import lc.wise.finenancer.domain.entity.Asset.Cash
import lc.wise.finenancer.domain.entity.Asset.Stock
import lc.wise.finenancer.domain.repository.AssetRepository
import lc.wise.finenancer.domain.repository.SettingStoreRepository
import lc.wise.finenancer.utils.AssetClass

class StubAssetEntity @Inject constructor(
    private val assetDao: AssetDao,
    private val cashDao: CashDao,
    private val stockDao: StockDao,
    private val bondDao: BondDao,
    private val currencyDao: CurrencyDao,
    private val countryDao: CountryDao,
    private val settingStoreRepository: SettingStoreRepository
) : AssetRepository {
    override fun getAssetByID(assetID: Int): Asset = when (assetDao.getAssetType(assetID)) {
        AssetClass.CASH.type -> {
            val cashEntity = cashDao.getCashById(assetID)
            cashEntity.toCash(
                currencyDao.getCurrencyByID(
                    cashEntity.currencyId
                ).toCurrency()
            )
        }

        AssetClass.STOCK.type -> {
            val stockEntity = stockDao.getStockById(assetID)
            stockEntity.toStock(
                currencyDao.getCurrencyByID(
                    stockEntity.currencyId
                ).toCurrency(),
                countryDao.getCountryByID(
                    stockEntity.countryId
                ).toCountry()
            )
        }

        AssetClass.BOND.type -> {
            val bondEntity = bondDao.getBondById(assetID)
            bondEntity.toBond(
                currencyDao.getCurrencyByID(
                    bondEntity.currencyId
                ).toCurrency(),
                countryDao.getCountryByID(
                    bondEntity.countryId
                ).toCountry()
            )
        }

        else -> throw IllegalArgumentException()
    }

    override fun getAllAssets(): List<Asset> =
        cashDao.getFullCashList().map { cashEntity ->
            cashEntity.toCash(
                currencyDao.getCurrencyByID(
                    cashEntity.currencyId
                ).toCurrency()
            )
        } + stockDao.getFullStocksList().map { stockEntity ->
            stockEntity.toStock(
                currencyDao.getCurrencyByID(
                    stockEntity.currencyId
                ).toCurrency(),
                countryDao.getCountryByID(
                    stockEntity.countryId
                ).toCountry()
            )
        } + bondDao.getFullBondsList().map { bondEntity ->
            bondEntity.toBond(
                currencyDao.getCurrencyByID(
                    bondEntity.currencyId
                ).toCurrency(),
                countryDao.getCountryByID(
                    bondEntity.countryId
                ).toCountry()
            )
        }

    override fun saveAsset(asset: Asset): Asset = when (asset) {
        is Cash -> {
            cashDao.saveCash(asset.toCashEntity())
            cashDao.getCashById(asset.assetId).toCash(
                currencyDao.getCurrencyByID(
                    asset.currency.currencyId
                ).toCurrency()
            )
        }

        is Stock -> {
            stockDao.saveStock(asset.toStockEntity())
            stockDao.getStockById(asset.assetId).toStock(
                currencyDao.getCurrencyByID(
                    asset.currency.currencyId
                ).toCurrency(),
                countryDao.getCountryByID(
                    asset.country.countryId
                ).toCountry()
            )
        }

        is Bond -> {
            bondDao.saveBond(asset.toBondEntity())
            bondDao.getBondById(asset.assetId).toBond(
                currencyDao.getCurrencyByID(
                    asset.currency.currencyId
                ).toCurrency(),
                countryDao.getCountryByID(
                    asset.country.countryId
                ).toCountry()
            )
        }
    }

    override fun deleteAsset(assetID: Int) = run {
        when (assetDao.getAssetType(assetID)) {
            AssetClass.CASH.type -> cashDao.deleteCash(cashDao.getCashById(assetID))
            AssetClass.STOCK.type -> stockDao.deleteStock(stockDao.getStockById(assetID))
            AssetClass.BOND.type -> bondDao.deleteBond(bondDao.getBondById(assetID))
            else -> throw IllegalArgumentException()
        }
        assetDao.deleteAsset(assetDao.getAssetByID(assetID))
    }
}
