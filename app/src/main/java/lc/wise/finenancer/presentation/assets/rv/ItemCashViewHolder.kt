package lc.wise.finenancer.presentation.assets.rv

import lc.wise.finenancer.R
import lc.wise.finenancer.databinding.ItemCashBinding
import lc.wise.finenancer.presentation.utils.AssetUI
import lc.wise.finenancer.presentation.utils.BaseViewHolder

class ItemCashViewHolder(
    val binding: ItemCashBinding
) : BaseViewHolder<AssetUI.CashUI>(binding.root) {

    override fun bind(cashUI: AssetUI.CashUI, onClick: (AssetUI.CashUI) -> Unit) {
        with(binding) {
            cashIcon.setImageResource(R.drawable.ic_launcher_foreground)
            cashName.text = cashUI.assetName
            cashWorth.text = cashUI.worth.toString()
            root.setOnClickListener {
                onClick(cashUI)
            }
        }
    }
}
