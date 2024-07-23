package lc.wise.finenancer.presentation.home

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.navigation.fragment.findNavController
import lc.wise.finenancer.R
import lc.wise.finenancer.databinding.FragmentHomeBinding
import lc.wise.finenancer.presentation.utils.BaseFragment

class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    override fun inflateBinding() = FragmentHomeBinding.inflate(layoutInflater)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            buttonAssetsList.setOnClickListener {
                findNavController().navigate(
                    HomeFragmentDirections.actionHomeFragmentToAssetsListFragment()
                )
            }
            buttonPortfolioList.setOnClickListener {
                findNavController().navigate(
                    HomeFragmentDirections.actionHomeFragmentToPortfolioListFragment()
                )
            }
        }

        // this also should be moved to home fragment viewmodel
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.home_fragment_settings, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.home_toolbar_settings -> {
                findNavController().navigate(
                    HomeFragmentDirections.actionHomeFragmentToSettingsFragment()
                )
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}
