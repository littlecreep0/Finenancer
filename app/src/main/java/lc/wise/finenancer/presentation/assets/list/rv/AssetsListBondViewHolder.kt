package lc.wise.finenancer.presentation.assets.list.rv

import lc.wise.finenancer.R
import lc.wise.finenancer.databinding.ItemBondBinding
import lc.wise.finenancer.domain.entity.Bond
import lc.wise.finenancer.presentation.utils.BaseViewHolder

class AssetsListBondViewHolder(
    val binding: ItemBondBinding
) : BaseViewHolder<Bond>(binding.root) {
    override fun bind(bond: Bond, onClick: (Bond) -> Unit) {
        with(binding) {
            bondIcon.setImageResource(R.drawable.ic_launcher_foreground)
            bondName.text = bond.name
            bondTicker.text = bond.ticker
            bondCountry.text = bond.country.name
            bondDate.text =
                bond.maturityDate.dayOfMonth.toString() +
                "/" +
                bond.maturityDate.monthValue.toString() +
                "/" +
                bond.maturityDate.year.toString()
            root.setOnClickListener {
                onClick(bond)
            }
        }
    }
}
