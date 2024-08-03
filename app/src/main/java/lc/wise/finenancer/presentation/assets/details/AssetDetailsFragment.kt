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
import lc.wise.finenancer.databinding.FragmentAssetDetailsBinding
import lc.wise.finenancer.presentation.utils.BaseFragment

@AndroidEntryPoint
class AssetDetailsFragment : BaseFragment<FragmentAssetDetailsBinding>() {
    private val viewModel: AssetDetailsViewModel by viewModels()

    override fun inflateBinding() = FragmentAssetDetailsBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        showDetails()

        setHasOptionsMenu(true)
    }

    private fun showDetails() {
        val args: AssetDetailsFragmentArgs by navArgs()
        val assetId = args.assetId
        viewModel.findAssetById(assetId)

        viewModel.asset.observe(viewLifecycleOwner) { asset ->
            asset?.let {
                with(binding) {
                    assetName.text = asset.name
                    assetTotalAmount.text = "Total Amount: ${asset.totalAmount}"
                }
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
                    requireActivity(),
                    "Edit Asset - Work In Progress",
                    Toast.LENGTH_SHORT
                ).show()
                true
            }

            R.id.details_options_delete -> {
                Toast.makeText(
                    requireActivity(),
                    "Delete Asset - Work In Progress",
                    Toast.LENGTH_SHORT
                ).show()
                true
            }

            R.id.details_options_settings -> {
                findNavController().navigate(
                    AssetDetailsFragmentDirections.actionAssetDetailsFragmentToSettingsFragment()
                )
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}
