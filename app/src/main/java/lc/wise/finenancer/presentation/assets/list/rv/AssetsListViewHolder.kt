package lc.wise.finenancer.presentation.assets.list.rv

import androidx.recyclerview.widget.RecyclerView
import lc.wise.finenancer.R
import lc.wise.finenancer.databinding.ItemAssetBinding
import lc.wise.finenancer.domain.entity.Asset

class AssetsListViewHolder(
    private val binding: ItemAssetBinding // there are also currencies, what do we do for them?
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(asset: Asset, onClick: (Asset) -> Unit) {
        with(binding) {
            assetIcon.setImageResource(R.drawable.ic_launcher_foreground)
            assetName.text = asset.name
            root.setOnClickListener {
                onClick(asset)
            }
        }
    }
}
