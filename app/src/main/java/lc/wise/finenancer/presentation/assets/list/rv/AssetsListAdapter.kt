package lc.wise.finenancer.presentation.assets.list.rv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import lc.wise.finenancer.databinding.ItemAssetBinding
import lc.wise.finenancer.domain.entity.Asset

class AssetsListAdapter : ListAdapter<Asset, AssetsListViewHolder>(AssetsListDiffUtil()) {

    var onClick: (Asset) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AssetsListViewHolder {
        return AssetsListViewHolder(
            ItemAssetBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: AssetsListViewHolder, position: Int) {
        holder.bind(getItem(position), onClick)
    }
}