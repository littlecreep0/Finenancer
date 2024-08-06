package lc.wise.finenancer.presentation.portfolio.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import lc.wise.finenancer.R
import lc.wise.finenancer.domain.entity.Portfolio
import lc.wise.finenancer.domain.repository.PortfolioRepository
import lc.wise.finenancer.presentation.utils.StringValue

@HiltViewModel
class PortfolioDetailsViewModel @Inject constructor(
    private val portfolioRepository: PortfolioRepository
) : ViewModel() {
    private val _portfolio = MutableLiveData<Portfolio>()
    val portfolio: LiveData<Portfolio> get() = _portfolio

    private val _toast by lazy { MutableLiveData<StringValue>() }
    val toast: LiveData<StringValue> get() = _toast

    fun findPortfolioById(id: Int) {
        try {
            _portfolio.value = portfolioRepository.getPortfolioByID(id)
        } catch (e: IllegalArgumentException) {
            _toast.postValue(StringValue.StringResource(R.string.no_portfolio))
        }
    }
}
