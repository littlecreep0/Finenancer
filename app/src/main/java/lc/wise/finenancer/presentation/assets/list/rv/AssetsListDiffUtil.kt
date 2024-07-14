package lc.wise.finenancer.presentation.assets.list.rv

import androidx.recyclerview.widget.DiffUtil
import lc.wise.finenancer.domain.entity.Asset

class AssetsListDiffUtil(
    private val oldAssetList: List<Asset>,
    private val newAssetList: List<Asset>
) : DiffUtil.Callback() {
    override fun getOldListSize() = oldAssetList.size
    override fun getNewListSize() = newAssetList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldAsset = oldAssetList[oldItemPosition]
        val newAsset = newAssetList[newItemPosition]
        return oldAsset.id == newAsset.id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldAsset = oldAssetList[oldItemPosition]
        val newAsset = newAssetList[newItemPosition]
        return oldAsset == newAsset
    }
}
