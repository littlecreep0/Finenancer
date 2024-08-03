package lc.wise.finenancer.presentation.portfolio.details.rv

import androidx.recyclerview.widget.DiffUtil
import lc.wise.finenancer.domain.entity.Stock

class PortfolioDetailsDiffUtil : DiffUtil.ItemCallback<Stock>() {
    override fun areItemsTheSame(oldItem: Stock, newItem: Stock): Boolean =
        oldItem == newItem

    override fun areContentsTheSame(oldItem: Stock, newItem: Stock): Boolean =
        oldItem == newItem
}
