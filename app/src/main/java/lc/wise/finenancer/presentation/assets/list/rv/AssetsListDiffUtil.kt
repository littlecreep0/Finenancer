package lc.wise.finenancer.presentation.assets.list.rv

import androidx.recyclerview.widget.DiffUtil
import lc.wise.finenancer.presentation.utils.AssetUI

class AssetsListDiffUtil : DiffUtil.ItemCallback<AssetUI>() {
    override fun areItemsTheSame(oldItem: AssetUI, newItem: AssetUI): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: AssetUI, newItem: AssetUI): Boolean =
        oldItem.javaClass.name == newItem.javaClass.name &&
            when (oldItem) {
                is AssetUI.CashUI -> oldItem == newItem
                is AssetUI.BondUI -> oldItem == newItem
                is AssetUI.StockUI -> oldItem == newItem
            }
}
