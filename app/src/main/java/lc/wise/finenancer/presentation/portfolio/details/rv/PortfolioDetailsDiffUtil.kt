package lc.wise.finenancer.presentation.portfolio.details.rv

import androidx.recyclerview.widget.DiffUtil
import lc.wise.finenancer.presentation.utils.AssetUI

class PortfolioDetailsDiffUtil : DiffUtil.ItemCallback<AssetUI>() {
    override fun areItemsTheSame(oldItem: AssetUI, newItem: AssetUI): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: AssetUI, newItem: AssetUI): Boolean =
        oldItem == newItem
}
