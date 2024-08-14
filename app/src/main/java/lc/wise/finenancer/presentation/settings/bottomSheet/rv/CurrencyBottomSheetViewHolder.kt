package lc.wise.finenancer.presentation.settings.bottomSheet.rv

import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import lc.wise.finenancer.R
import lc.wise.finenancer.databinding.ItemCurrencyBinding
import lc.wise.finenancer.domain.entity.Currency

class CurrencyBottomSheetViewHolder(
    binding: ItemCurrencyBinding,
    private val onCurrencySelected: (Currency) -> Unit
) : RecyclerView.ViewHolder(binding.root) {
    private val currencyName: TextView = itemView.findViewById(R.id.currencyName)

    fun bind(currency: Currency) {
        currencyName.text = currency.name
        itemView.setOnClickListener {
            onCurrencySelected(currency)
        }
    }
}
