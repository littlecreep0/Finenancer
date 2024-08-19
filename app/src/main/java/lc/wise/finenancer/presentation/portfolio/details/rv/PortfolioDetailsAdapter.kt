package lc.wise.finenancer.presentation.portfolio.details.rv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import lc.wise.finenancer.domain.entity.Asset
import lc.wise.finenancer.presentation.utils.BaseViewHolder
import lc.wise.finenancer.presentation.utils.TypeFactoryImpl

class PortfolioDetailsAdapter :
    ListAdapter<Asset, BaseViewHolder<Asset>>(PortfolioDetailsDiffUtil()) {

    private val typeFactory = TypeFactoryImpl()
    var onClick: (Asset) -> Unit = {}

    override fun getItemViewType(position: Int) = getItem(position).type(typeFactory)

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
