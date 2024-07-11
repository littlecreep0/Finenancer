package lc.wise.finenancer.data.stub.repository

import lc.wise.finenancer.data.stub.StubData
import lc.wise.finenancer.domain.entity.Asset
import lc.wise.finenancer.domain.repository.AssetRepository

class StubAssetRepository : AssetRepository {
    override fun getAssetByID(assetID: Int): Asset? =
        StubData.assetList.find { it.id == assetID }

    override fun getAllAssets(): List<Asset> =
        StubData.assetList
}
