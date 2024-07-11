package lc.wise.finenancer.domain.repository

import lc.wise.finenancer.domain.entity.Asset

interface AssetRepository {
    fun createAsset()
    fun getAssetByID(assetID: Int): Asset?
    fun getAllAssets(): List<Asset>
    fun updateAsset(assetID: Int): Asset?
    fun deleteAsset(assetID: Int): Asset?
}
