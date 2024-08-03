package lc.wise.finenancer.presentation.assets.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import lc.wise.finenancer.data.stub.repository.StubAssetRepository
import lc.wise.finenancer.domain.entity.Asset

@HiltViewModel
class AssetDetailsViewModel @Inject constructor(
    private val stubAssetRepository: StubAssetRepository
) : ViewModel() {
    private val _asset = MutableLiveData<Asset>()
    val asset: LiveData<Asset> get() = _asset

    private val _toast = MutableLiveData<String>()
    val toast: LiveData<String> get() = _toast

    fun findAssetById(id: Int) {
        try {
            _asset.value = stubAssetRepository.getAssetByID(id)
        } catch (e: IllegalArgumentException) {
            _toast.value = "Failed to load asset: no asset with this ID found"
        }
    }
}
