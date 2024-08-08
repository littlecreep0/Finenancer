package lc.wise.finenancer.presentation.portfolio.list

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
import lc.wise.finenancer.databinding.FragmentPortfolioListBinding
import lc.wise.finenancer.presentation.portfolio.list.rv.PortfolioListAdapter
import lc.wise.finenancer.presentation.utils.BaseFragment
@AndroidEntryPoint
class PortfolioListFragment : BaseFragment<FragmentPortfolioListBinding>() {
    private val viewModel: PortfolioListViewModel by viewModels()
    override fun inflateBinding() = FragmentPortfolioListBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupAdapter()

        setHasOptionsMenu(true)
    }

    private fun setupAdapter() {
        val adapter = PortfolioListAdapter()
        binding.portfolioList.adapter = adapter

        viewModel.portfolioList.observe(viewLifecycleOwner) { portfolio ->
            portfolio?.let { adapter.submitList(portfolio) }
        }

        adapter.onClick = { portfolio ->
            portfolio?.let {
                findNavController().navigate(
                    PortfolioListFragmentDirections
                        .actionPortfolioListFragmentToPortfolioDetailsFragment(
                            portfolio.id
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
                    PortfolioListFragmentDirections.actionPortfolioListFragmentToSettingsFragment()
                )
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}
