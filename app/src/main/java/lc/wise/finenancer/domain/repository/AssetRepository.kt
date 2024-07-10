package lc.wise.finenancer.domain.repository

import lc.wise.finenancer.data.StubData
import lc.wise.finenancer.domain.entities.Asset

interface AssetRepositoryInterface {
    fun getAssetByID(assetID: Int): Asset?
    fun getAllAssets(): MutableList<Asset>
}

class AssetRepository : AssetRepositoryInterface {
    override fun getAssetByID(assetID: Int): Asset? {
        return StubData.assetList.find { it.id == assetID }
    }

    override fun getAllAssets(): MutableList<Asset> {
        return StubData.assetList
    }
}
