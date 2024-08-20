package lc.wise.finenancer.data.stub.database

import java.time.LocalDate
import javax.inject.Inject
import kotlin.random.Random
import lc.wise.finenancer.data.dao.AssetDao
import lc.wise.finenancer.data.dao.BondDao
import lc.wise.finenancer.data.dao.CashDao
import lc.wise.finenancer.data.dao.StockDao
import lc.wise.finenancer.domain.entity.Asset
import lc.wise.finenancer.domain.entity.Asset.Bond
import lc.wise.finenancer.domain.entity.Asset.Cash
import lc.wise.finenancer.domain.entity.Asset.Stock
import lc.wise.finenancer.domain.entity.Country
import lc.wise.finenancer.domain.entity.Currency
import lc.wise.finenancer.domain.repository.AssetRepository
import lc.wise.finenancer.domain.repository.SettingStoreRepository
import lc.wise.finenancer.presentation.utils.AssetClass

class StubAssetEntity @Inject constructor(
    private val assetDao: AssetDao,
    private val cashDao: CashDao,
    private val stockDao: StockDao,
    private val bondDao: BondDao,
    private val settingStoreRepository: SettingStoreRepository
) : AssetRepository {
    override fun getAssetByID(assetID: Int): Asset? = when (assetDao.getAssetType(assetID)) {
        AssetClass.CASH.type -> cashDao.getCashById(assetID)
        AssetClass.STOCK.type -> stockDao.getStockById(assetID)
        AssetClass.BOND.type -> bondDao.getBondById(assetID)
        else -> throw IllegalArgumentException()
    }

    override fun getAllAssets(): List<Asset> =
        cashDao.getCashList() + stockDao.getStocksList() + bondDao.getBondsList()

    override fun saveAsset(asset: Asset): Asset? = when (asset) {
        is Cash -> {
            val randomID = Random.nextInt()
            val randomWorth = Random.nextDouble()
            cashDao.saveCash(
                Cash(
                    randomID, "Cash $randomID", // written in text input field by user
                    Currency(randomID, "Currency $randomID"),
                    // chosen in currency picker by user
                    randomWorth // written in text input field by user
                )
            )
        }

        is Stock -> {
            val randomID = Random.nextInt()
            val randomDividends = Random.nextDouble()
            stockDao.saveStock(
                Stock(
                    randomID, "Stock $randomID", // written in text input field by user
                    Currency(randomID, "Currency $randomID"),
                    // chosen in currency picker by user
                    "STCK", // written in text input field by user
                    Country(randomID, "Belarus"), // chosen in country picker by user
                    randomDividends
                )
            )
        }

        is Bond -> {
            val randomID = Random.nextInt()
            val randomPayment = Random.nextDouble()
            bondDao.saveBond(
                Bond(
                    randomID, "Bond $randomID", // written in text input field by user
                    Currency(randomID, "Currency $randomID"),
                    // chosen in currency picker by user
                    "BND", // written in text input field by user
                    Country(randomID, "Belarus"), // chosen in country picker by user
                    randomPayment, // written in text input field by user
                    LocalDate.now() // chosen in date picker by user
                )
            )
        }
    }

    override fun deleteAsset(assetID: Int) = when (assetDao.getAssetType(assetID)) {
        AssetClass.CASH.type -> cashDao.deleteCash(assetID)
        AssetClass.STOCK.type -> stockDao.deleteStock(assetID)
        AssetClass.BOND.type -> bondDao.deleteBond(assetID)
        else -> throw IllegalArgumentException()
    }
}
