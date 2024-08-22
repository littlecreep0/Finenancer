package lc.wise.finenancer.presentation.settings.bottomSheet.rv

import androidx.recyclerview.widget.DiffUtil
import lc.wise.finenancer.domain.entity.Currency

class CurrencyBottomSheetDiffUtil : DiffUtil.ItemCallback<Currency>() {
    override fun areItemsTheSame(oldItem: Currency, newItem: Currency): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Currency, newItem: Currency): Boolean =
        oldItem.javaClass.name == newItem.javaClass.name
}
