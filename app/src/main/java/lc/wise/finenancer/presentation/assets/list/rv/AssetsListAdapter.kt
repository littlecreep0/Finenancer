package lc.wise.finenancer.presentation.assets.list.rv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import lc.wise.finenancer.presentation.utils.AssetUI
import lc.wise.finenancer.presentation.utils.BaseViewHolder
import lc.wise.finenancer.presentation.utils.TypeFactoryImpl

class AssetsListAdapter : ListAdapter<AssetUI, BaseViewHolder<AssetUI>>(AssetsListDiffUtil()) {

    private val typeFactory = TypeFactoryImpl()
    var onClick: (AssetUI) -> Unit = {}

    override fun getItemViewType(position: Int) = getItem(position).type(typeFactory)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<AssetUI> {
        return typeFactory.holder(
            LayoutInflater.from(parent.context),
            parent,
            viewType
        ) as BaseViewHolder<AssetUI>
    }

    override fun onBindViewHolder(holder: BaseViewHolder<AssetUI>, position: Int) {
        holder.bind(getItem(position), onClick)
    }
}
