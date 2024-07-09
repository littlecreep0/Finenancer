package lc.wise.finenancer.presentation.portfolio.list

import lc.wise.finenancer.databinding.FragmentPortfolioListBinding
import lc.wise.finenancer.presentation.BaseFragment

class PortfolioListFragment : BaseFragment<FragmentPortfolioListBinding>() {
    override fun getViewBinding(): FragmentPortfolioListBinding = FragmentPortfolioListBinding
        .inflate(layoutInflater)
}
