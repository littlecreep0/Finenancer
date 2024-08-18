package lc.wise.finenancer.presentation.assets.list.rv

import androidx.recyclerview.widget.DiffUtil
import lc.wise.finenancer.domain.entity.Asset

class AssetsListDiffUtil : DiffUtil.ItemCallback<Asset>() {
    override fun areItemsTheSame(oldItem: Asset, newItem: Asset): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Asset, newItem: Asset): Boolean =
        oldItem == newItem
}
