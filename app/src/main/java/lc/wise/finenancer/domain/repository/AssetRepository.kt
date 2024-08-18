package lc.wise.finenancer.domain.repository

import lc.wise.finenancer.domain.entity.Asset

interface AssetRepository {
    fun getAssetByID(assetID: Int): Asset?
    fun getAllAssets(): List<Asset>
    fun saveAsset(asset: Asset): Asset?
    fun deleteAsset(assetID: Int)
}
