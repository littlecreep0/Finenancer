package lc.wise.finenancer.presentation.portfolio.list.rv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import lc.wise.finenancer.databinding.ItemPortfolioBinding
import lc.wise.finenancer.domain.entity.Portfolio

class PortfolioListAdapter :
    ListAdapter<Portfolio, PortfolioListViewHolder>(PortfolioListDiffUtil()) {

    var onClick: (Portfolio) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PortfolioListViewHolder {
        return PortfolioListViewHolder(
            ItemPortfolioBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: PortfolioListViewHolder, position: Int) {
        holder.bind(getItem(position), onClick)
    }
}
