package lc.wise.finenancer.presentation.portfolio.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import lc.wise.finenancer.R
import lc.wise.finenancer.domain.entity.Portfolio
import lc.wise.finenancer.domain.interactors.PortfolioInteractor
import lc.wise.finenancer.presentation.utils.StringValue

@HiltViewModel
class PortfolioDetailsViewModel @Inject constructor(
    private val portfolioInteractor: PortfolioInteractor
) : ViewModel() {
    private val _portfolio = MutableLiveData<Portfolio>()
    val portfolio: LiveData<Portfolio> get() = _portfolio

    private val _toast = MutableLiveData<String>()
    val toast: LiveData<String> get() = _toast

    fun findPortfolioById(id: Int) {
        try {
            _portfolio.value = portfolioInteractor.getPortfolioByID(id)
        } catch (e: IllegalArgumentException) {
            _toast.postValue(StringValue.getStringRes(R.string.no_portfolio))
        }
    }
}
