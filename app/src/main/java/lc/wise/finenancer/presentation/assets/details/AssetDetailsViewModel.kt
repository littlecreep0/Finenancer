package lc.wise.finenancer.presentation.assets.details

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import lc.wise.finenancer.R
import lc.wise.finenancer.domain.entity.Asset.Bond
import lc.wise.finenancer.domain.entity.Asset.Cash
import lc.wise.finenancer.domain.entity.Asset.Stock
import lc.wise.finenancer.domain.interactors.AssetsInteractor

@HiltViewModel
class AssetDetailsViewModel @Inject constructor(
    private val assetInteractor: AssetsInteractor,
    @ApplicationContext private val context: Context
) : ViewModel() {

    private val _cash = MutableLiveData<Cash?>()
    val cash: LiveData<Cash?> get() = _cash

    private val _stock = MutableLiveData<Stock?>()
    val stock: LiveData<Stock?> get() = _stock

    private val _bond = MutableLiveData<Bond?>()
    val bond: LiveData<Bond?> get() = _bond

    private val _toast = MutableLiveData<String>()
    val toast: LiveData<String> get() = _toast

    fun findAssetById(id: Int) {
        try {
            val asset = assetInteractor.getAssetByID(id)
            asset?.let {
                when (asset) {
                    is Cash -> _cash.value = asset
                    is Stock -> _stock.value = asset
                    is Bond -> _bond.value = asset
                }
            }
        } catch (e: IllegalArgumentException) {
            _toast.postValue(context.getString(R.string.no_asset))
        }
    }
}
