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
import lc.wise.finenancer.databinding.FragmentCashDetailsBinding
import lc.wise.finenancer.presentation.utils.BaseFragment

@AndroidEntryPoint
class AssetDetailsCashFragment : BaseFragment<FragmentCashDetailsBinding>() {
    private val viewModel: AssetDetailsViewModel by viewModels()
    val args: AssetDetailsCashFragmentArgs by navArgs()

    override fun inflateBinding() = FragmentCashDetailsBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        showDetails()

        setHasOptionsMenu(true)
    }

    private fun showDetails() {
        val assetId = args.assetId

        viewModel.findAssetById(assetId)

        viewModel.cash.observe(viewLifecycleOwner) { cash ->
            cash?.let {
                with(binding) {
                    cashName.text = cash.name
                    cashWorth.text = getString(
                        R.string.worth,
                        cash.worth
                    )
                }
            }
        }

        viewModel.toast.observe(viewLifecycleOwner) { toast ->
            toast?.let {
                Toast.makeText(
                    requireActivity(), it.asString(requireContext()), Toast.LENGTH_SHORT
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
                    requireActivity(), R.string.wip, Toast.LENGTH_SHORT
                ).show()
                true
            }

            R.id.details_options_delete -> {
                Toast.makeText(
                    requireActivity(), R.string.wip, Toast.LENGTH_SHORT
                ).show()
                true
            }

            R.id.details_options_settings -> {
                findNavController().navigate(
                    AssetDetailsCashFragmentDirections
                        .actionAssetDetailsCashFragmentToSettingsFragment()
                )
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}
