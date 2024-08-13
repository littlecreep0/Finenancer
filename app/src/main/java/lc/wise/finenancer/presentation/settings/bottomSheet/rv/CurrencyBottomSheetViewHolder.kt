package lc.wise.finenancer.presentation.settings.bottomSheet.rv

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import lc.wise.finenancer.R
import lc.wise.finenancer.domain.entity.Currency

class CurrencyBottomSheetViewHolder(
    itemView: View,
    private val onCurrencySelected: (Currency) -> Unit
) : RecyclerView.ViewHolder(itemView) {
    private val currencyName: TextView = itemView.findViewById(R.id.currencyName)

    fun bind(currency: Currency) {
        currencyName.text = currency.name
        itemView.setOnClickListener {
            onCurrencySelected(currency)
        }
    }
}
