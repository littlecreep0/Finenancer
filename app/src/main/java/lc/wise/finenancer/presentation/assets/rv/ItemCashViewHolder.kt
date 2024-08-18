package lc.wise.finenancer.presentation.assets.rv

import android.view.LayoutInflater
import android.view.ViewGroup
import lc.wise.finenancer.R
import lc.wise.finenancer.databinding.ItemCashBinding
import lc.wise.finenancer.domain.entity.Cash
import lc.wise.finenancer.presentation.utils.BaseViewHolder

class ItemCashViewHolder(
    val binding: ItemCashBinding
) : BaseViewHolder<Cash>(binding.root) {

    companion object {
        fun createViewHolder(inflater: LayoutInflater, parent: ViewGroup): ItemCashViewHolder {
            val binding = ItemCashBinding.inflate(inflater, parent, false)
            return ItemCashViewHolder(binding)
        }
    }

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
