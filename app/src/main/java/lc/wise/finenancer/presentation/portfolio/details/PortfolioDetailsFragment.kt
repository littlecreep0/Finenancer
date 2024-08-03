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
import lc.wise.finenancer.presentation.utils.BaseFragment

@AndroidEntryPoint
class PortfolioDetailsFragment : BaseFragment<FragmentPortfolioDetailsBinding>() {
    private val viewModel: PortfolioDetailsViewModel by viewModels()
    override fun inflateBinding() = FragmentPortfolioDetailsBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        showDetails()

        setHasOptionsMenu(true)
    }

    private fun showDetails() {
        val args: PortfolioDetailsFragmentArgs by navArgs()
        val portfolioId = args.portfolioId
        viewModel.findPortfolioById(portfolioId)

        viewModel.portfolio.observe(viewLifecycleOwner) { portfolio ->
            portfolio?.let {
                with(binding) {
                    portfolioName.text = portfolio.name
                }
            }
        }

        val adapter = PortfolioDetailsAdapter()
        binding.portfolioStocksList.adapter = adapter

        viewModel.stocksList.observe(viewLifecycleOwner) { stocks ->
            stocks?.let { adapter.submitList(stocks) }
        }

        adapter.onClick = { stock ->
            stock?.let {
                findNavController().navigate(
                    PortfolioDetailsFragmentDirections
                        .actionPortfolioDetailsFragmentToAssetDetailsFragment(
                            stock.id
                        )
                )
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
                    requireActivity(),
                    "Edit Portfolio - Work In Progress",
                    Toast.LENGTH_SHORT
                ).show()
                true
            }

            R.id.details_options_delete -> {
                Toast.makeText(
                    requireActivity(),
                    "Delete Portfolio - Work In Progress",
                    Toast.LENGTH_SHORT
                ).show()
                true
            }

            R.id.details_options_history -> {
                Toast.makeText(
                    requireActivity(),
                    "Portfolio History - Work In Progress",
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
