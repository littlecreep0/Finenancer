package lc.wise.finenancer.presentation.assets.list.rv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import lc.wise.finenancer.databinding.ItemBondBinding
import lc.wise.finenancer.databinding.ItemCashBinding
import lc.wise.finenancer.databinding.ItemStockBinding
import lc.wise.finenancer.domain.entity.Asset
import lc.wise.finenancer.domain.entity.Bond
import lc.wise.finenancer.domain.entity.Cash
import lc.wise.finenancer.domain.entity.Stock
import lc.wise.finenancer.presentation.utils.AssetViewType
import lc.wise.finenancer.presentation.utils.BaseViewHolder

class AssetsListAdapter : ListAdapter<Asset, BaseViewHolder<Asset>>(AssetsListDiffUtil()) {

    var onClick: (Asset) -> Unit = {}

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is Cash -> AssetViewType.CASH.viewType
            is Stock -> AssetViewType.STOCK.viewType
            is Bond -> AssetViewType.BOND.viewType
            else -> super.getItemViewType(position)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Asset> {
        return when (viewType) {
            AssetViewType.CASH.viewType -> {
                AssetsListCashViewHolder(
                    ItemCashBinding.inflate(
                        LayoutInflater.from(parent.context), parent, false
                    )
                )
            }

            AssetViewType.STOCK.viewType -> {
                AssetsListStockViewHolder(
                    ItemStockBinding.inflate(
                        LayoutInflater.from(parent.context), parent, false
                    )
                )
            }

            AssetViewType.BOND.viewType -> {
                AssetsListBondViewHolder(
                    ItemBondBinding.inflate(
                        LayoutInflater.from(parent.context), parent, false
                    )
                )
            }

            else -> {
                throw IllegalArgumentException("")
            }
        } as BaseViewHolder<Asset>
    }

    override fun onBindViewHolder(holder: BaseViewHolder<Asset>, position: Int) {
        holder.bind(getItem(position), onClick)
    }
}
