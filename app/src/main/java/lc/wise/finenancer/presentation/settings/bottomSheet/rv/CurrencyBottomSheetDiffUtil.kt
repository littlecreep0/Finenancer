package lc.wise.finenancer.presentation.settings.bottomSheet.rv

import androidx.recyclerview.widget.DiffUtil
import lc.wise.finenancer.domain.entity.Currency

class CurrencyBottomSheetDiffUtil : DiffUtil.ItemCallback<Currency>() {
    override fun areItemsTheSame(oldItem: Currency, newItem: Currency): Boolean =
        oldItem == newItem

    override fun areContentsTheSame(oldItem: Currency, newItem: Currency): Boolean =
        oldItem == newItem
}
