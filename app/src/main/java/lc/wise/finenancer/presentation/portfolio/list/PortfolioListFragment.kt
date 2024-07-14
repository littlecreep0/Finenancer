package lc.wise.finenancer.presentation.portfolio.list

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import lc.wise.finenancer.R
import lc.wise.finenancer.data.stub.StubData
import lc.wise.finenancer.databinding.FragmentPortfolioListBinding
import lc.wise.finenancer.presentation.portfolio.list.rv.PortfolioListAdapter
import lc.wise.finenancer.presentation.utils.BaseFragment

class PortfolioListFragment : BaseFragment<FragmentPortfolioListBinding>() {
    override fun inflateBinding() = FragmentPortfolioListBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = PortfolioListAdapter()
        binding.portfolioList.adapter = adapter

        // !! THE FOLLOWING CODE JUST SHOWS THAT THE RECYCLERVIEW WORKS
        // proper inflation with viewmodel + dependency injection + hilt
        // will be introduced in a separate PR
        val portfolioList = StubData.portfolioList
        adapter.submit(portfolioList)
        adapter.onClick = {
            Toast.makeText(
                requireActivity(),
                "Portfolio Info - Work In Progress",
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
                    "Create Portfolio - Work In Progress",
                    Toast.LENGTH_SHORT
                ).show()
                true
            }
            R.id.toolbar_options_edit -> {
                Toast.makeText(
                    requireActivity(),
                    "Edit Portfolio - Work In Progress",
                    Toast.LENGTH_SHORT
                ).show()
                true
            }
            R.id.toolbar_options_delete -> {
                Toast.makeText(
                    requireActivity(),
                    "Delete Portfolio - Work In Progress",
                    Toast.LENGTH_SHORT
                ).show()
                true
            }
            R.id.toolbar_options_settings -> {
                findNavController().navigate(
                    PortfolioListFragmentDirections.actionPortfolioListFragmentToSettingsFragment()
                )
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
