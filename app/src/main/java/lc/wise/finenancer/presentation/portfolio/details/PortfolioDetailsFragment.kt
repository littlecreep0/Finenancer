package lc.wise.finenancer.presentation.portfolio.details

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import lc.wise.finenancer.R
import lc.wise.finenancer.databinding.FragmentPortfolioDetailsBinding
import lc.wise.finenancer.presentation.portfolio.details.rv.PortfolioDetailsAdapter
import lc.wise.finenancer.presentation.utils.AssetUI
import lc.wise.finenancer.presentation.utils.BaseFragment
import lc.wise.finenancer.presentation.utils.toAssetUIList

@AndroidEntryPoint
class PortfolioDetailsFragment : BaseFragment<FragmentPortfolioDetailsBinding>() {
    private val viewModel: PortfolioDetailsViewModel by viewModels()
    val args: PortfolioDetailsFragmentArgs by navArgs()

    override fun inflateBinding() = FragmentPortfolioDetailsBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        showDetails()

        setHasOptionsMenu(true)
    }

    private fun showDetails() {
        val portfolioId = args.portfolioId
        viewModel.findPortfolioById(portfolioId)

        val adapter = PortfolioDetailsAdapter()
        binding.portfolioAssetsList.adapter = adapter

        viewModel.portfolio.observe(viewLifecycleOwner) { portfolio ->
            portfolio?.let {
                with(binding) {
                    portfolioName.text = portfolio.name
                    portfolioAssets.text = getString(
                        R.string.assets_in_portfolio,
                        portfolio.assetsList.size
                    )
                }
                adapter.submitList(portfolio.assetsList.toAssetUIList())
            }
        }

        adapter.onClick = { asset ->
            asset?.let {
                val action = when (asset) {
                    is AssetUI.CashUI ->
                        PortfolioDetailsFragmentDirections
                            .actionPortfolioDetailsFragmentToAssetDetailsCashFragment(
                                asset.id
                            )

                    is AssetUI.StockUI ->
                        PortfolioDetailsFragmentDirections
                            .actionPortfolioDetailsFragmentToAssetDetailsStockFragment(
                                asset.id
                            )

                    is AssetUI.BondUI ->
                        PortfolioDetailsFragmentDirections
                            .actionPortfolioDetailsFragmentToAssetDetailsBondFragment(
                                asset.id
                            )
                }
                findNavController().navigate(action)
            }
        }

        viewModel.toast.observe(viewLifecycleOwner) { toast ->
            toast?.let {
                Toast.makeText(
                    requireContext(),
                    it,
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_portfolio_details_options, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.details_options_edit -> {
                Toast.makeText(
                    requireContext(),
                    R.string.wip,
                    Toast.LENGTH_SHORT
                ).show()
                true
            }

            R.id.details_options_delete -> {
                Toast.makeText(
                    requireContext(),
                    R.string.wip,
                    Toast.LENGTH_SHORT
                ).show()
                true
            }

            R.id.details_options_history -> {
                Toast.makeText(
                    requireContext(),
                    R.string.wip,
                    Toast.LENGTH_SHORT
                ).show()
                true
            }

            R.id.details_options_settings -> {
                findNavController().navigate(
                    PortfolioDetailsFragmentDirections
                        .actionPortfolioDetailsFragmentToSettingsFragment()
                )
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}
