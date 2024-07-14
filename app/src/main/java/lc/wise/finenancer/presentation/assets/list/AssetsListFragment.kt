package lc.wise.finenancer.presentation.assets.list

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import lc.wise.finenancer.R
import lc.wise.finenancer.data.stub.StubData
import lc.wise.finenancer.databinding.FragmentAssetsListBinding
import lc.wise.finenancer.presentation.assets.list.rv.AssetsListAdapter
import lc.wise.finenancer.presentation.utils.BaseFragment

class AssetsListFragment : BaseFragment<FragmentAssetsListBinding>() {
    override fun inflateBinding() = FragmentAssetsListBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = AssetsListAdapter()
        binding.assetsList.adapter = adapter

        // !! the following code is used to show that the recycler view works
        // proper inflation with viewmodel + dependency injection + hilt
        // will be introduced in a separate PR
        val assetsList = StubData.assetList
        adapter.submit(assetsList)
        adapter.onClick = {
            Toast.makeText(
                requireActivity(),
                "Asset Info - Work In Progress",
                Toast.LENGTH_SHORT
            ).show()
        }

        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.toolbar_options, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.toolbar_options_create -> {
                Toast.makeText(
                    requireActivity(),
                    "Create Asset - Work In Progress",
                    Toast.LENGTH_SHORT
                ).show()
                true
            }
            R.id.toolbar_options_edit -> {
                Toast.makeText(
                    requireActivity(),
                    "Edit Asset - Work In Progress",
                    Toast.LENGTH_SHORT
                ).show()
                true
            }
            R.id.toolbar_options_delete -> {
                Toast.makeText(
                    requireActivity(),
                    "Delete Asset - Work In Progress",
                    Toast.LENGTH_SHORT
                ).show()
                true
            }
            R.id.toolbar_options_settings -> {
                findNavController().navigate(
                    AssetsListFragmentDirections.actionAssetsListFragmentToSettingsFragment()
                )
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
