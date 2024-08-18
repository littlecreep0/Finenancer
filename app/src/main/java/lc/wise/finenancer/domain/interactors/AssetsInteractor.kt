package lc.wise.finenancer.domain.interactors

import javax.inject.Inject
import javax.inject.Singleton
import lc.wise.finenancer.domain.entity.Asset
import lc.wise.finenancer.domain.repository.AssetRepository

@Singleton
class AssetsInteractor @Inject constructor(
    private val assetRepository: AssetRepository
) {
    fun getAssetByID(assetID: Int) = assetRepository.getAssetByID(assetID)
    fun getAssetList() = assetRepository.getAllAssets()
    fun saveAsset(asset: Asset) = assetRepository.saveAsset(asset)
    fun deleteAsset(assetID: Int) = assetRepository.deleteAsset(assetID)
}
