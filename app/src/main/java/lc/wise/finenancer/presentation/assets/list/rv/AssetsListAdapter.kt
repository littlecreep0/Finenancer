package lc.wise.finenancer.presentation.assets.list.rv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView.Adapter
import lc.wise.finenancer.databinding.ItemAssetBinding
import lc.wise.finenancer.domain.entity.Asset

class AssetsListAdapter : Adapter<AssetsListViewHolder>() {

    var onClick: (Asset) -> Unit = {}
    private var assetList = emptyList<Asset>()
    override fun getItemCount() = assetList.size

    fun submit(newAssetList: List<Asset>) {
        val diffCallback = AssetsListDiffUtil(assetList, newAssetList)
        val diffAssets = DiffUtil.calculateDiff(diffCallback)
        assetList = newAssetList
        diffAssets.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AssetsListViewHolder {
        return AssetsListViewHolder(
            ItemAssetBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: AssetsListViewHolder, position: Int) {
        holder.bind(assetList[position], onClick)
    }
}
