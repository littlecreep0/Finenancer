package lc.wise.finenancer.presentation.assets.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import lc.wise.finenancer.domain.entity.Asset
import lc.wise.finenancer.domain.repository.AssetRepository

@HiltViewModel
class AssetsListViewModel @Inject constructor(
    private val assetRepository: AssetRepository
) : ViewModel() {
    private val _assetsList = MutableLiveData<List<Asset>>()
    val assetsList: LiveData<List<Asset>> get() = _assetsList

    init {
        loadAssetsList()
    }

    private fun loadAssetsList() {
        _assetsList.value = assetRepository.getAllAssets()
    }
}
