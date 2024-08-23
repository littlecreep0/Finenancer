package lc.wise.finenancer.presentation.portfolio.details.rv

import androidx.recyclerview.widget.DiffUtil
import lc.wise.finenancer.presentation.utils.AssetUI

class PortfolioDetailsDiffUtil : DiffUtil.ItemCallback<AssetUI>() {
    override fun areItemsTheSame(oldItem: AssetUI, newItem: AssetUI): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: AssetUI, newItem: AssetUI): Boolean =
        when (oldItem) {
            is AssetUI.CashUI -> oldItem == newItem
            is AssetUI.BondUI -> oldItem == newItem
            is AssetUI.StockUI -> oldItem == newItem
        }
}
