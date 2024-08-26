package lc.wise.finenancer.presentation.assets.list.rv

import androidx.recyclerview.widget.DiffUtil
import lc.wise.finenancer.presentation.utils.AssetUI

class AssetsListDiffUtil : DiffUtil.ItemCallback<AssetUI>() {
    override fun areItemsTheSame(oldItem: AssetUI, newItem: AssetUI): Boolean =
        oldItem.assetId == newItem.assetId

    override fun areContentsTheSame(oldItem: AssetUI, newItem: AssetUI): Boolean =
        oldItem == newItem
}
