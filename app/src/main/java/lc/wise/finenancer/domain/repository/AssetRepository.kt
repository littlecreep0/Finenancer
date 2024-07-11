package lc.wise.finenancer.domain.repository

import lc.wise.finenancer.domain.entity.Asset

interface IAssetRepository {
    fun getAssetByID(assetID: Int): Asset?
    fun getAllAssets(): List<Asset>
}
