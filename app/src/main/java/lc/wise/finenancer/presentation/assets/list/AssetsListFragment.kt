package lc.wise.finenancer.presentation.assets.list

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import lc.wise.finenancer.R
import lc.wise.finenancer.databinding.FragmentAssetsListBinding
import lc.wise.finenancer.presentation.assets.list.rv.AssetsListAdapter
import lc.wise.finenancer.presentation.utils.BaseFragment

@AndroidEntryPoint
class AssetsListFragment : BaseFragment<FragmentAssetsListBinding>() {
    private val viewModel: AssetsListViewModel by viewModels()
    override fun inflateBinding() = FragmentAssetsListBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupAdapter()

        setHasOptionsMenu(true)
    }

    private fun setupAdapter() {
        val adapter = AssetsListAdapter()
        binding.assetsList.adapter = adapter

        viewModel.assetsList.observe(viewLifecycleOwner) { assets ->
            assets?.let { adapter.submitList(assets) }
        }

        adapter.onClick = { asset ->
            asset?.let {
                findNavController().navigate(
                    AssetsListFragmentDirections.actionAssetsListFragmentToAssetDetailsFragment(
                        asset.id
                    )
                )
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_lists_options, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.lists_options_create -> {
                Toast.makeText(
                    requireActivity(),
                    R.string.wip,
                    Toast.LENGTH_SHORT
                ).show()
                true
            }

            R.id.lists_options_edit -> {
                Toast.makeText(
                    requireActivity(),
                    R.string.wip,
                    Toast.LENGTH_SHORT
                ).show()
                true
            }

            R.id.lists_options_delete -> {
                Toast.makeText(
                    requireActivity(),
                    R.string.wip,
                    Toast.LENGTH_SHORT
                ).show()
                true
            }

            R.id.lists_options_settings -> {
                findNavController().navigate(
                    AssetsListFragmentDirections.actionAssetsListFragmentToSettingsFragment()
                )
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}
