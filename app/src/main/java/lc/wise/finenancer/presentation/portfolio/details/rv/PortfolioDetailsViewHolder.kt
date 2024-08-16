package lc.wise.finenancer.presentation.portfolio.details.rv

import androidx.recyclerview.widget.RecyclerView
import lc.wise.finenancer.R
import lc.wise.finenancer.databinding.ItemStockBinding
import lc.wise.finenancer.domain.entity.Stock

class PortfolioDetailsViewHolder(
    private val binding: ItemStockBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(stock: Stock, onClick: (Stock) -> Unit) {
        with(binding) {
            stockIcon.setImageResource(R.drawable.ic_launcher_foreground)
            stockName.text = stock.name
            root.setOnClickListener {
                onClick(stock)
            }
        }
    }
}
