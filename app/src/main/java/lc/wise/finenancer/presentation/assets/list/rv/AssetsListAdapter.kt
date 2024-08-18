package lc.wise.finenancer.presentation.assets.list.rv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import lc.wise.finenancer.domain.entity.Asset
import lc.wise.finenancer.domain.entity.Bond
import lc.wise.finenancer.domain.entity.Cash
import lc.wise.finenancer.domain.entity.Stock
import lc.wise.finenancer.presentation.utils.AssetViewType
import lc.wise.finenancer.presentation.utils.BaseViewHolder
import lc.wise.finenancer.presentation.utils.TypeFactoryImpl

class AssetsListAdapter : ListAdapter<Asset, BaseViewHolder<Asset>>(AssetsListDiffUtil()) {

    private val typeFactory = TypeFactoryImpl()
    var onClick: (Asset) -> Unit = {}

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is Cash -> AssetViewType.CASH.ordinal
            is Stock -> AssetViewType.STOCK.ordinal
            is Bond -> AssetViewType.BOND.ordinal
            else -> super.getItemViewType(position)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Asset> {
        return typeFactory.holder(
            LayoutInflater.from(parent.context),
            parent,
            viewType
        ) as BaseViewHolder<Asset>
    }

    override fun onBindViewHolder(holder: BaseViewHolder<Asset>, position: Int) {
        holder.bind(getItem(position), onClick)
    }
}
