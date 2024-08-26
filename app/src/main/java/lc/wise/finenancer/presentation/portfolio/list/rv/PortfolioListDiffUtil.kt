package lc.wise.finenancer.presentation.portfolio.list.rv

import androidx.recyclerview.widget.DiffUtil
import lc.wise.finenancer.domain.entity.Portfolio

class PortfolioListDiffUtil : DiffUtil.ItemCallback<Portfolio>() {
    override fun areItemsTheSame(oldItem: Portfolio, newItem: Portfolio): Boolean =
        oldItem.portfolioId == newItem.portfolioId

    override fun areContentsTheSame(oldItem: Portfolio, newItem: Portfolio): Boolean =
        oldItem == newItem
}
