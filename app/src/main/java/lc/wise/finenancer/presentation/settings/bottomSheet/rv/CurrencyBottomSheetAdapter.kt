package lc.wise.finenancer.presentation.settings.bottomSheet.rv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import lc.wise.finenancer.R
import lc.wise.finenancer.domain.entity.Currency

class CurrencyBottomSheetAdapter(private val onCurrencySelected: (Currency) -> Unit) :
    ListAdapter<Currency, CurrencyBottomSheetViewHolder>(
        CurrencyBottomSheetDiffUtil()
    ) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CurrencyBottomSheetViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_currency, parent, false)
        return CurrencyBottomSheetViewHolder(view, onCurrencySelected)
    }

    override fun onBindViewHolder(holder: CurrencyBottomSheetViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}
