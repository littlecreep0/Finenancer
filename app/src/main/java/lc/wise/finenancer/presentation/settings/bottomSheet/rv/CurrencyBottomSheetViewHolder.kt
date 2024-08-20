package lc.wise.finenancer.presentation.settings.bottomSheet.rv

import androidx.recyclerview.widget.RecyclerView
import lc.wise.finenancer.databinding.ItemCurrencyBinding
import lc.wise.finenancer.domain.entity.Currency

class CurrencyBottomSheetViewHolder(
    private val binding: ItemCurrencyBinding,
    private val onCurrencySelected: (Currency) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(currency: Currency) {
        binding.currencyName.text = currency.name
        itemView.setOnClickListener {
            onCurrencySelected(currency)
        }
    }
}
