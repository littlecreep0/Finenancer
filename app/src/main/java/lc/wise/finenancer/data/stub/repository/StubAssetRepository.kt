package lc.wise.finenancer.data.stub.repository

import lc.wise.finenancer.data.stub.StubData
import lc.wise.finenancer.domain.entity.Asset
import lc.wise.finenancer.domain.repository.IAssetRepository

class StubAssetRepository : IAssetRepository {
    override fun getAssetByID(assetID: Int): Asset? {
        return StubData.assetList.find { it.id == assetID }
    }

    override fun getAllAssets(): List<Asset> {
        return StubData.assetList
    }
}
