package lc.wise.finenancer.presentation.assets.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import lc.wise.finenancer.R
import lc.wise.finenancer.domain.entity.Bond
import lc.wise.finenancer.domain.entity.Cash
import lc.wise.finenancer.domain.entity.Stock
import lc.wise.finenancer.domain.interactors.AssetsInteractor
import lc.wise.finenancer.presentation.utils.StringValue

@HiltViewModel
class AssetDetailsViewModel @Inject constructor(
    private val assetInteractor: AssetsInteractor
) : ViewModel() {

    private val _cash = MutableLiveData<Cash?>()
    val cash: LiveData<Cash?> get() = _cash

    private val _stock = MutableLiveData<Stock?>()
    val stock: LiveData<Stock?> get() = _stock

    private val _bond = MutableLiveData<Bond?>()
    val bond: LiveData<Bond?> get() = _bond

    private val _toast by lazy { MutableLiveData<StringValue>() }
    val toast: LiveData<StringValue> get() = _toast

    fun findAssetById(id: Int) {
        try {
            when (val asset = assetInteractor.getAssetByID(id)) {
                is Cash -> _cash.value = asset
                is Stock -> _stock.value = asset
                is Bond -> _bond.value = asset
                else -> throw IllegalArgumentException()
            }
        } catch (e: IllegalArgumentException) {
            _toast.postValue(StringValue.StringResource(R.string.no_asset))
        }
    }
}
