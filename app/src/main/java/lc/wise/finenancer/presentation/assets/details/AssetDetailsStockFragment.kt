package lc.wise.finenancer.presentation.assets.details

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
import lc.wise.finenancer.databinding.FragmentStockDetailsBinding
import lc.wise.finenancer.presentation.utils.BaseFragment

@AndroidEntryPoint
class AssetDetailsStockFragment : BaseFragment<FragmentStockDetailsBinding>() {
    private val viewModel: AssetDetailsViewModel by viewModels()
    val args: AssetDetailsStockFragmentArgs by navArgs()

    override fun inflateBinding() = FragmentStockDetailsBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        showDetails()

        setHasOptionsMenu(true)
    }

    private fun showDetails() {
        val assetId = args.assetId

        viewModel.findAssetById(assetId)

        viewModel.stock.observe(viewLifecycleOwner) { stock ->
            stock?.let {
                with(binding) {
                    stockName.text = stock.assetName
                    stockTicker.text = stock.ticker
                    stockCountry.text = getString(
                        R.string.country,
                        stock.country.countryName
                    )
                    stockDividends.text = getString(
                        R.string.dividends,
                        stock.dividends
                    )
                }
            }
        }

        viewModel.toast.observe(viewLifecycleOwner) { toast ->
            toast?.let {
                Toast.makeText(
                    requireContext(), it, Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_asset_details_options, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.details_options_edit -> {
                Toast.makeText(
                    requireContext(), R.string.wip, Toast.LENGTH_SHORT
                ).show()
                true
            }

            R.id.details_options_delete -> {
                Toast.makeText(
                    requireContext(), R.string.wip, Toast.LENGTH_SHORT
                ).show()
                true
            }

            R.id.details_options_settings -> {
                findNavController().navigate(
                    AssetDetailsStockFragmentDirections
                        .actionAssetDetailsStockFragmentToSettingsFragment()
                )
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}
