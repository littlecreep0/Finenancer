package lc.wise.finenancer.presentation.portfolio.details.rv

import androidx.recyclerview.widget.DiffUtil
import lc.wise.finenancer.domain.entity.Asset

class PortfolioDetailsDiffUtil : DiffUtil.ItemCallback<Asset>() {
    override fun areItemsTheSame(oldItem: Asset, newItem: Asset): Boolean =
        oldItem == newItem

    override fun areContentsTheSame(oldItem: Asset, newItem: Asset): Boolean =
        oldItem == newItem
}
