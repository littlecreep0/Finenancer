package lc.wise.finenancer.presentation.settings

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch
import lc.wise.finenancer.domain.entity.Currency
import lc.wise.finenancer.domain.repository.CurrencyRepository
import lc.wise.finenancer.domain.repository.SettingStoreRepository

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val settingStore: SettingStoreRepository,
    private val currencyRepository: CurrencyRepository
) : ViewModel() {
    private val _settings: MutableLiveData<String> = MutableLiveData()
    val settings: LiveData<String> get() = _settings

    private val _currenciesList: MutableLiveData<List<Currency>> = MutableLiveData()
    val currenciesList: LiveData<List<Currency>> get() = _currenciesList

    init {
        viewModelScope.launch {
            settingStore.getDefaultCurrency().collect {
                _settings.postValue(it)
            }
        }
        loadCurrencies()
    }

    private fun loadCurrencies() {
        viewModelScope.launch {
            _currenciesList.value = currencyRepository.getAllCurrencies()
        }
    }

    fun setDefaultCurrency(currency: String) {
        viewModelScope.launch {
            settingStore.setDefaultCurrency(currency)
            _settings.value = currency
        }
    }
}
