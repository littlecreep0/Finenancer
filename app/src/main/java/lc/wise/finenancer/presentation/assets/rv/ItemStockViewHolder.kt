package lc.wise.finenancer.presentation.assets.rv

import android.view.LayoutInflater
import android.view.ViewGroup
import lc.wise.finenancer.R
import lc.wise.finenancer.databinding.ItemStockBinding
import lc.wise.finenancer.domain.entity.Stock
import lc.wise.finenancer.presentation.utils.BaseViewHolder

class ItemStockViewHolder(
    val binding: ItemStockBinding
) : BaseViewHolder<Stock>(binding.root) {

    companion object {
        fun createViewHolder(inflater: LayoutInflater, parent: ViewGroup): ItemStockViewHolder {
            val binding = ItemStockBinding.inflate(inflater, parent, false)
            return ItemStockViewHolder(binding)
        }
    }

    override fun bind(stock: Stock, onClick: (Stock) -> Unit) {
        with(binding) {
            stockIcon.setImageResource(R.drawable.ic_launcher_foreground)
            stockName.text = stock.name
            stockTicker.text = stock.ticker
            stockCountry.text = stock.country.name
            root.setOnClickListener {
                onClick(stock)
            }
        }
    }
}
