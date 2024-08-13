package lc.wise.finenancer.presentation.portfolio.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import lc.wise.finenancer.domain.entity.Portfolio
import lc.wise.finenancer.domain.interactors.PortfolioInteractor

@HiltViewModel
class PortfolioListViewModel @Inject constructor(
    private val portfolioListInteractor: PortfolioInteractor
) : ViewModel() {
    private val _portfolioList = MutableLiveData<List<Portfolio>>()
    val portfolioList: LiveData<List<Portfolio>> get() = _portfolioList

    init {
        loadPortfolioList()
    }

    private fun loadPortfolioList() {
        _portfolioList.value = portfolioListInteractor.getPortfolioList()
    }
}
