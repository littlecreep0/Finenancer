package lc.wise.finenancer.presentation.assets.list.rv

import lc.wise.finenancer.R
import lc.wise.finenancer.databinding.ItemCashBinding
import lc.wise.finenancer.domain.entity.Cash
import lc.wise.finenancer.presentation.utils.BaseViewHolder

class AssetsListCashViewHolder(
    val binding: ItemCashBinding
) : BaseViewHolder<Cash>(binding.root) {
    override fun bind(cash: Cash, onClick: (Cash) -> Unit) {
        with(binding) {
            cashIcon.setImageResource(R.drawable.ic_launcher_foreground)
            cashName.text = cash.name
            cashWorth.text = cash.worth.toString()
            root.setOnClickListener {
                onClick(cash)
            }
        }
    }
}
