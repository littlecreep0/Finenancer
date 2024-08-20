package lc.wise.finenancer.presentation.utils

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<T>(
    open val view: View
) : RecyclerView.ViewHolder(view) {
    abstract fun bind(asset: T, onClick: (T) -> Unit)
}
