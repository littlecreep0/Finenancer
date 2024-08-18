package lc.wise.finenancer.presentation.assets.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import lc.wise.finenancer.R
import lc.wise.finenancer.domain.entity.Asset
import lc.wise.finenancer.domain.interactors.AssetsInteractor
import lc.wise.finenancer.presentation.utils.StringValue

@HiltViewModel
class AssetDetailsViewModel @Inject constructor(
    private val assetInteractor: AssetsInteractor
) : ViewModel() {
    private val _asset = MutableLiveData<Asset>()
    val asset: LiveData<Asset> get() = _asset

    private val _toast by lazy { MutableLiveData<StringValue>() }
    val toast: LiveData<StringValue> get() = _toast

    fun findAssetById(id: Int) {
        try {
            _asset.value = assetInteractor.getAssetByID(id)
        } catch (e: IllegalArgumentException) {
            _toast.postValue(StringValue.StringResource(R.string.no_asset))
        }
    }
}
