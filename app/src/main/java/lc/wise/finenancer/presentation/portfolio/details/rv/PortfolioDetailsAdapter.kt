package lc.wise.finenancer.presentation.portfolio.details.rv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import lc.wise.finenancer.databinding.ItemStockBinding
import lc.wise.finenancer.domain.entity.Stock

class PortfolioDetailsAdapter :
    ListAdapter<Stock, PortfolioDetailsViewHolder>(PortfolioDetailsDiffUtil()) {
    var onClick: (Stock) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PortfolioDetailsViewHolder {
        return PortfolioDetailsViewHolder(
            ItemStockBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: PortfolioDetailsViewHolder, position: Int) {
        holder.bind(getItem(position), onClick)
    }
}
