package lc.wise.finenancer.presentation.portfolio.list.rv

import androidx.recyclerview.widget.RecyclerView
import lc.wise.finenancer.R
import lc.wise.finenancer.databinding.ItemPortfolioBinding
import lc.wise.finenancer.domain.entity.Portfolio
import lc.wise.finenancer.presentation.utils.StringValue

class PortfolioListViewHolder(
    private val binding: ItemPortfolioBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(portfolio: Portfolio, onClick: (Portfolio) -> Unit) {
        with(binding) {
            portfolioIcon.setImageResource(R.drawable.ic_launcher_foreground)
            portfolioName.text = portfolio.name
            portfolioAssetsAmount.text = StringValue.getStringRes(
                R.string.assets_in_portfolio,
                portfolio.assetsList.size
            )
            root.setOnClickListener {
                onClick(portfolio)
            }
        }
    }
}
