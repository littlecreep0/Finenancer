package lc.wise.finenancer.domain.interactors

import javax.inject.Inject
import javax.inject.Singleton
import lc.wise.finenancer.domain.repository.AssetRepository

@Singleton
class AssetsInteractor @Inject constructor(
    private val assetRepository: AssetRepository
) {
    fun createAsset() = assetRepository.createAsset()
    fun getAssetByID(assetID: Int) = assetRepository.getAssetByID(assetID)
    fun getAssetList() = assetRepository.getAllAssets()
    fun editAsset(assetID: Int) = assetRepository.editAsset(assetID)
    fun deleteAsset(assetID: Int) = assetRepository.deleteAsset(assetID)
}
