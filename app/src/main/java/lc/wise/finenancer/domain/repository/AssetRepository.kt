package lc.wise.finenancer.domain.repository

import lc.wise.finenancer.domain.entity.Asset

interface AssetRepository {
    fun createAsset(): Asset?
    fun getAssetByID(assetID: Int): Asset?
    fun getAllAssets(): List<Asset>
    fun editAsset(assetID: Int): Asset?
    fun deleteAsset(assetID: Int)
}
