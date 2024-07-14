package lc.wise.finenancer.presentation.portfolio.list.rv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import lc.wise.finenancer.databinding.ItemPortfolioBinding
import lc.wise.finenancer.domain.entity.Portfolio

class PortfolioListAdapter : RecyclerView.Adapter<PortfolioListViewHolder>() {

    var onClick: (Portfolio) -> Unit = {}
    private var portfolioList = emptyList<Portfolio>()
    override fun getItemCount() = portfolioList.size

    fun submit(newPortfolioList: List<Portfolio>) {
        val diffCallback = PortfolioListDiffUtil(portfolioList, newPortfolioList)
        val diffAssets = DiffUtil.calculateDiff(diffCallback)
        portfolioList = newPortfolioList
        diffAssets.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PortfolioListViewHolder {
        return PortfolioListViewHolder(
            ItemPortfolioBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: PortfolioListViewHolder, position: Int) {
        holder.bind(portfolioList[position], onClick)
    }
}
