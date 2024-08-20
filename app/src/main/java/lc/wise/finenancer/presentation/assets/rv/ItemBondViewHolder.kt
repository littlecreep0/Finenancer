package lc.wise.finenancer.presentation.assets.rv

import lc.wise.finenancer.R
import lc.wise.finenancer.databinding.ItemBondBinding
import lc.wise.finenancer.presentation.utils.AssetUI
import lc.wise.finenancer.presentation.utils.BaseViewHolder
import lc.wise.finenancer.presentation.utils.StringValue

class ItemBondViewHolder(
    val binding: ItemBondBinding
) : BaseViewHolder<AssetUI.BondUI>(binding.root) {

    override fun bind(bondUI: AssetUI.BondUI, onClick: (AssetUI.BondUI) -> Unit) {
        with(binding) {
            bondIcon.setImageResource(R.drawable.ic_launcher_foreground)
            bondName.text = bondUI.name
            bondTicker.text = bondUI.ticker
            bondCountry.text = bondUI.country
            bondDate.text = StringValue.getStringRes(
                R.string.date,
                bondUI.maturityDateDay,
                bondUI.maturityDateMonth,
                bondUI.maturityDateYear
            )
            root.setOnClickListener {
                onClick(bondUI)
            }
        }
    }
}
