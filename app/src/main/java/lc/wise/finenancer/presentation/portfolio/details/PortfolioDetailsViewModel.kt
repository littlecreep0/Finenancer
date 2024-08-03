package lc.wise.finenancer.presentation.portfolio.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import lc.wise.finenancer.data.stub.repository.StubPortfolioItemRepository
import lc.wise.finenancer.data.stub.repository.StubPortfolioRepository
import lc.wise.finenancer.domain.entity.Portfolio
import lc.wise.finenancer.domain.entity.Stock

@HiltViewModel
class PortfolioDetailsViewModel @Inject constructor(
    private val stubPortfolioRepository: StubPortfolioRepository,
    private val stubPortfolioItemRepository: StubPortfolioItemRepository
) : ViewModel() {
    private val _portfolio = MutableLiveData<Portfolio>()
    val portfolio: LiveData<Portfolio> get() = _portfolio

    private val _stocksList = MutableLiveData<List<Stock>>()
    val stocksList: LiveData<List<Stock>> get() = _stocksList

    private val _toast = MutableLiveData<String>()
    val toast: LiveData<String> get() = _toast

    init {
        loadStocksList()
    }

    fun findPortfolioById(id: Int) {
        try {
            _portfolio.value = stubPortfolioRepository.getPortfolioByID(id)
        } catch (e: IllegalArgumentException) {
            _toast.value = "Failed to load portfolio: no portfolio with this ID found"
        }
    }

    private fun loadStocksList() {
        _stocksList.value = stubPortfolioItemRepository.getAllStocks()
    }
}
