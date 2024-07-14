package lc.wise.finenancer.presentation.portfolio.list.rv

import androidx.recyclerview.widget.DiffUtil
import lc.wise.finenancer.domain.entity.Portfolio

class PortfolioListDiffUtil(
    private val oldPortfolioList: List<Portfolio>,
    private val newPortfolioList: List<Portfolio>
) : DiffUtil.Callback() {
    override fun getOldListSize() = oldPortfolioList.size
    override fun getNewListSize() = newPortfolioList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldPortfolio = oldPortfolioList[oldItemPosition]
        val newPortfolio = newPortfolioList[newItemPosition]
        return oldPortfolio.id == newPortfolio.id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldPortfolio = oldPortfolioList[oldItemPosition]
        val newPortfolio = newPortfolioList[newItemPosition]
        return oldPortfolio == newPortfolio
    }
}
