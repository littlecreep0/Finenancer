package lc.wise.finenancer.presentation.portfolio.details.rv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import lc.wise.finenancer.databinding.ItemAssetBinding
import lc.wise.finenancer.domain.entity.Asset

class PortfolioDetailsAdapter :
    ListAdapter<Asset, PortfolioDetailsViewHolder>(PortfolioDetailsDiffUtil()) {
    var onClick: (Asset) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PortfolioDetailsViewHolder {
        return PortfolioDetailsViewHolder(
            ItemAssetBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: PortfolioDetailsViewHolder, position: Int) {
        holder.bind(getItem(position), onClick)
    }
}
