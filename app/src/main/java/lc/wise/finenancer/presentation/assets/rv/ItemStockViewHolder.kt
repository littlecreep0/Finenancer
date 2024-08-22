package lc.wise.finenancer.presentation.assets.rv

import lc.wise.finenancer.R
import lc.wise.finenancer.databinding.ItemStockBinding
import lc.wise.finenancer.presentation.utils.AssetUI
import lc.wise.finenancer.presentation.utils.BaseViewHolder

class ItemStockViewHolder(
    val binding: ItemStockBinding
) : BaseViewHolder<AssetUI.StockUI>(binding.root) {

    override fun bind(stockUI: AssetUI.StockUI, onClick: (AssetUI.StockUI) -> Unit) {
        with(binding) {
            stockIcon.setImageResource(R.drawable.ic_launcher_foreground)
            stockName.text = stockUI.assetName
            stockTicker.text = stockUI.ticker
            stockCountry.text = stockUI.country
            root.setOnClickListener {
                onClick(stockUI)
            }
        }
    }
}
